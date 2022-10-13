package com.app_dictionary_simple.controller;

import com.app_dictionary_simple.service.impl.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DictionaryAppSimple {
    @Autowired
    DictionaryService dictionaryService;
    @GetMapping
    public String showDictionary(){
        return "views";
    }

    @PostMapping("/result")
    public String resultDictionary(@RequestParam String english, Model model){
      model.addAttribute("english",english);
      model.addAttribute("result",dictionaryService.dictionary(english));
      return "views";
    }

}