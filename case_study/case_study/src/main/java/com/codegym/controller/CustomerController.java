package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.customer.Customer;
import com.codegym.service.ICustomerService;
import com.codegym.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    //    @GetMapping
//    public String showList(@PageableDefault(value = 4) Pageable pageable, Model model) {
//        model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
//        Page<Customer> customerPage = iCustomerService.findAll(pageable);
//        model.addAttribute("customerList", customerPage);
//        return "customer/customerList";
//    }
    @GetMapping
    public String showList(@RequestParam(value = "page", defaultValue = "0") Integer page,
                           @RequestParam(name = "name", defaultValue = "") String name,
                           @RequestParam(name = "email", defaultValue = "") String email,
                           @RequestParam(name = "customerTypeList", defaultValue = "") String customerTypeList,
                           @RequestParam(name = "deleteStatus", defaultValue = "1") String deleteStatus,
                           Model model) {
        Sort sort = Sort.by("name").ascending();
        model.addAttribute("customerType", iCustomerTypeService.findAll());
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("customerTypeList", customerTypeList);
        if (customerTypeList.equals("") && name.equals("") && email.equals("")) {
            model.addAttribute("customerList", iCustomerService.findByStatus(deleteStatus, PageRequest.of(page, 5, sort)));
        } else if (customerTypeList.equals("")) {
            model.addAttribute("customerList", iCustomerService.findByNameAndEmail(name, email, deleteStatus, PageRequest.of(page, 5, sort)));
        } else {
            model.addAttribute("customerList", iCustomerService.findByNameAndEmailAndCustomerType(name, email, deleteStatus, customerTypeList, PageRequest.of(page, 5, sort)));
        }
        return "/customer/customerList";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        model.addAttribute("customerList", new CustomerDto());
        return "customer/customerCreate";
    }

    @PostMapping("/save")
    public String create(CustomerDto customerDto, RedirectAttributes redirectAttributes) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.create(customer);
        redirectAttributes.addFlashAttribute("mess", "Add Success!!");
        return "redirect:/customer";
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
    public String delete(@RequestParam(value = "delete") int id,RedirectAttributes redirectAttributes){
        Customer customer=iCustomerService.findById(id);
        customer.setDeleteStatus(0);
        iCustomerService.update(customer);
        redirectAttributes.addFlashAttribute("mess","delete Success!!");
        return "redirect:/customer";
    }
}