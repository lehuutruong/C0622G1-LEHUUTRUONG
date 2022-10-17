package com.program_to_store_email_configuration.controller;
import com.program_to_store_email_configuration.model.Configuration;
import com.program_to_store_email_configuration.service.IConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConfigurationEmailController {
    @Autowired
    public IConfigurationService configurationService;

    @GetMapping
    public String showForm(ModelMap modelMap) {
        modelMap.addAttribute("mail", new Configuration());
        modelMap.addAttribute("languageList", configurationService.languageList());
        modelMap.addAttribute("sizeList", configurationService.sizeList());
        return "home";
    }

    @PostMapping("/home")
    public String updateMailBox(@ModelAttribute("mail") Configuration configuration, Model model) {
        model.addAttribute("message", "Update success");
        return "update";
    }
}
