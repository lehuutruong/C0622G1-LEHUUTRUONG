package com.calculator.controller;

import com.calculator.service.impl.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;

    @GetMapping
    public String showCalculator() {
        return "calculator";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam double parameterOne, @RequestParam double parameterTwo, @RequestParam String calculation, Model model) {
        model.addAttribute("parameterOne", parameterOne);
        model.addAttribute("parameterTwo", parameterTwo);
        model.addAttribute("calculation", calculation);
        model.addAttribute("result", calculatorService.calculator(parameterOne, parameterTwo, calculation));
        return "calculator";
    }
}
