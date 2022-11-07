package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.dto.FacilityDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.facility.Facility;
import com.codegym.service.facility.IFacilityService;
import com.codegym.service.facility.IFacilityTypeService;
import com.codegym.service.facility.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IFacilityTypeService iFacilityTypeService;
    @Autowired
    private IRentTypeService iRentTypeService;
    @GetMapping
    public ModelAndView showFacilityList(@RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                                         @RequestParam(value = "facilityType", defaultValue = "") String facilityType,
                                         @PageableDefault(value = 3) Pageable pageable,Model model) {
        ModelAndView modelAndView = new ModelAndView("facility/facilityList");
        modelAndView.addObject("facilityList", iFacilityService.search(nameSearch,facilityType, pageable));
        modelAndView.addObject("rentType",iRentTypeService.finAll());
        modelAndView.addObject("facilityTypeList", iFacilityTypeService.findAll());
        modelAndView.addObject("facilityType", facilityType);
        modelAndView.addObject("nameSearch", nameSearch);
        return modelAndView;
    }
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAll());
        model.addAttribute("rentType",iRentTypeService.finAll());
        model.addAttribute("facilityList", new FacilityDto());
        return "facility/facilityCreate";
    }

    @PostMapping("/save")
    public String create(FacilityDto facilityDto, RedirectAttributes redirectAttributes) {
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        iFacilityService.create(facility);
        redirectAttributes.addFlashAttribute("mess", "Add Success!!");
        return "redirect:/facility";
    }

    @GetMapping("{id}/edit")
    public String showUpdate(@PathVariable int id, Model model) {
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAll());
        model.addAttribute("facilityList", iFacilityService.findById(id));
        model.addAttribute("rentType",iRentTypeService.finAll());
        return "facility/facilityEdit";
    }

    @PostMapping("/update")
    public String update(FacilityDto facilityDto, RedirectAttributes redirectAttributes) {
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        iFacilityService.update(facility);
        redirectAttributes.addFlashAttribute("messUpdate", "Update Success");
        return "redirect:/facility";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(value = "delete") int id, RedirectAttributes redirectAttributes) {
        Facility facility = iFacilityService.findById(id);
        facility.setDeleteStatus(0);
        iFacilityService.update(facility);
        redirectAttributes.addFlashAttribute("mess", "delete Success!!");
        return "redirect:/facility";
    }

    @GetMapping("{id}/view")
    public String showView(@PathVariable int id, Model model) {
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAll());
        model.addAttribute("facilityList", iFacilityService.findById(id));
        return "/facility/facilityView";
    }
}
