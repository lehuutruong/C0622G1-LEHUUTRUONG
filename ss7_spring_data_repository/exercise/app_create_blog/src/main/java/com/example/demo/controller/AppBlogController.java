package com.example.demo.controller;

import com.example.demo.model.AppBlog;
import com.example.demo.service.IAdminService;
import com.example.demo.service.IAppBlogService;
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
@RequestMapping("/home")
public class AppBlogController {
    @Autowired
    IAppBlogService appBlogService;

    @Autowired
    ICategoryService categoryService;

    @Autowired
    IAdminService adminService;
    @GetMapping("")
    public String index(Model model) {
        List<AppBlog> appBlogs = appBlogService.findAll();
//        model.addAttribute("adminList",admin)
        model.addAttribute("blog", appBlogs);
        return "home";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("categoryList",categoryService.findAll());
        model.addAttribute("admin",adminService.findAll());
        model.addAttribute("blog", new AppBlog());
        return "create";
    }

    @PostMapping("/save")
    public String save(AppBlog appBlog, RedirectAttributes redirectAttributes) {
        appBlogService.create(appBlog);
        redirectAttributes.addFlashAttribute("mess", "Add success");
        return ("redirect:/home");
    }

    @GetMapping("{id}/delete")
    public String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("blog", appBlogService.findById(id));
        return "delete";
    }

    @PostMapping("/remove")
    public String delete(AppBlog appBlog, RedirectAttributes redirectAttributes) {
        appBlogService.remove(appBlog);
        redirectAttributes.addFlashAttribute("messDelete", "Delete success");
        return "redirect:/home";
    }

    @GetMapping("{id}/edit")
    public String showUpdate(@PathVariable int id, Model model) {
        model.addAttribute("blog", appBlogService.findById(id));
        return ("edit");
    }

    @PostMapping("/update")
    public String update(AppBlog appBlog) {
        appBlogService.update(appBlog);
        return ("redirect:/home");
    }
}
