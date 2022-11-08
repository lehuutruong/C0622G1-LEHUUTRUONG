package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contractDetail")
public class ContractDetailController {
    @GetMapping
    public String showListContractDetail(){

        return "contract/contractDetail";
    }
}
