package com.check_mail.controller;

import com.check_mail.service.impl.CheckMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckMailController {
    @Autowired
    CheckMailService checkMailService;
    @GetMapping
    public String check(){
        return "check";
    }
    @GetMapping("/check")
    public String checkMail(@RequestParam String email, Model model) {
        model.addAttribute("email", email);
        model.addAttribute("check", checkMailService.checkMail(email));
        return "check";
    }
}
