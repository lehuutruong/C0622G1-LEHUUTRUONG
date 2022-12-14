package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.service.contract.IContractService;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.ICustomerTypeService;
import com.codegym.service.facility.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IContractService iContractService;

    @ModelAttribute("customerTypeList")
    public List<CustomerType> listCustomerType() {
        return iCustomerTypeService.findAll();
    }

    @GetMapping
    public ModelAndView showCustomerList(@RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                                         @RequestParam(value = "email", defaultValue = "") String email,
                                         @RequestParam(value = "customerType", defaultValue = "") String customerType,
                                         @PageableDefault(value = 3) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("customer/customerList");
        modelAndView.addObject("customerList", iCustomerService.search(nameSearch, email, customerType, pageable));
        modelAndView.addObject("customerTypeList", iCustomerTypeService.findAll());
        modelAndView.addObject("customerType", customerType);
        modelAndView.addObject("email", email);
        modelAndView.addObject("nameSearch", nameSearch);
        return modelAndView;

    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/customerCreate";
    }

    @PostMapping("/save")
    public String create(@Validated @ModelAttribute CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        List<Customer> customers = iCustomerService.findAll();
        List<String> emailList = new ArrayList<>();
        for (Customer item : customers) {
            emailList.add(item.getEmail());
            emailList.add(item.getIdCard());
        }
        customerDto.setEmailList(emailList);
       customerDto.validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "customer/customerCreate";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            iCustomerService.create(customer);
            redirectAttributes.addFlashAttribute("mess", "Add Success!!");
            return "redirect:/customer";
        }
    }

    @GetMapping("{id}/edit")
    public String showUpdate(@PathVariable int id, Model model) {
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        model.addAttribute("customerList", iCustomerService.findById(id));
        return "customer/customerEdit";
    }

    @PostMapping("/update")
    public String update(CustomerDto customerDto, RedirectAttributes redirectAttributes) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.update(customer);
        redirectAttributes.addFlashAttribute("messUpdate", "Update Success");
        return "redirect:/customer";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(value = "delete") int id, RedirectAttributes redirectAttributes) {
        Customer customer = iCustomerService.findById(id);
        customer.setDeleteStatus(0);
        iCustomerService.update(customer);
        redirectAttributes.addFlashAttribute("mess", "delete Success!!");
        return "redirect:/customer";
    }

    @GetMapping("{id}/view")
    public String showView(@PathVariable int id, Model model) {
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        model.addAttribute("customerList", iCustomerService.findById(id));
        return "/customer/customerView";
    }

}