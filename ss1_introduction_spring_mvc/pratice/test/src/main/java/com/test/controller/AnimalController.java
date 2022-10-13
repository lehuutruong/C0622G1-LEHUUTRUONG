package com.test.controller;

import com.test.model.Animal;
import com.test.service.impl.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AnimalController {
    @Autowired
  AnimalService animalService;
  @GetMapping
  public String showList(Model model){
      List<Animal> animalList=animalService.findAll();
   model.addAttribute("animalList",animalList);
 return "views";
  }
}
