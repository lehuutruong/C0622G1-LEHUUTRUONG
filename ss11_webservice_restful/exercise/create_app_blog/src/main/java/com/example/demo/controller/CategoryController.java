package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
     @Autowired
    ICategoryService categoryService;

     @GetMapping("")
    public String index(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("category", categories);
        return "Category/homeCategory";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
             model.addAttribute("category", new Category());
        return "Category/createCategory";
    }

    @PostMapping("/save")
    public String save(Category category, RedirectAttributes redirectAttributes) {
        categoryService.create(category);
        redirectAttributes.addFlashAttribute("mess", "Add success");
        return ("redirect:/category");
    }

    @GetMapping("{id}/delete")
    public String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "Category/deleteCategory";
    }

    @PostMapping("/remove")
    public String delete(Category category, RedirectAttributes redirectAttributes) {
        categoryService.remove(category);
        redirectAttributes.addFlashAttribute("messDelete", "Delete success");
        return "redirect:/category";
    }

    @GetMapping("{id}/edit")
    public String showUpdate(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return ("Category/editCategory");
    }

    @PostMapping("/update")
    public String update(Category category) {
        categoryService.update(category);
        return ("redirect:/category");
    }
    @GetMapping("{id}/view")
    public String showView(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return ("Category/viewCategory");
    }

}
