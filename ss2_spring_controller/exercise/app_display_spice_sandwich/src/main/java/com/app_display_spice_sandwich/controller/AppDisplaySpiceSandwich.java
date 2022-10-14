package com.app_display_spice_sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppDisplaySpiceSandwich {
    @GetMapping
    public String showList() {
        return "sandwich";
    }

    @GetMapping("/display")
    public String showListSpice(@RequestParam(value = "condiment", required = false) String[] condiment, Model model) {
        model.addAttribute("condiment", condiment);
        return "sandwich";
    }
}
