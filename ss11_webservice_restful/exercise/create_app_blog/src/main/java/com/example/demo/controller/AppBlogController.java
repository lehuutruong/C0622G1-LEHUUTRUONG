package com.example.demo.controller;

import com.example.demo.model.AppBlog;
import com.example.demo.service.IAdminService;
import com.example.demo.service.IAppBlogService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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
    public String index(@PageableDefault(value = 3) Pageable pageable, Model model) {
        Page<AppBlog> appBlogs = appBlogService.findAll(pageable);
        model.addAttribute("blog", appBlogs);
        return "AppBlog/homeAppBlog";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("admin", adminService.findAll());
        model.addAttribute("blog", new AppBlog());
        return "AppBlog/createAppBlog";
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
        return "AppBlog/deleteAppBlog";
    }

    @PostMapping("/remove")
    public String delete(AppBlog appBlog, RedirectAttributes redirectAttributes) {
        appBlogService.remove(appBlog);
        redirectAttributes.addFlashAttribute("messDelete", "Delete success");
        return "redirect:/home";
    }

    @GetMapping("{id}/edit")
    public String showUpdate(@PathVariable int id, Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("admin", adminService.findAll());
        model.addAttribute("blog", appBlogService.findById(id));
        return ("AppBlog/editAppBlog");
    }

    @PostMapping("/update")
    public String update(AppBlog appBlog) {
        appBlogService.update(appBlog);
        return ("redirect:/home");
    }
    @GetMapping("{id}/view")
    public String showView(@PathVariable int id, Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("admin", adminService.findAll());
        model.addAttribute("blog", appBlogService.findById(id));
        return ("AppBlog/viewAppBlog");
    }

    @GetMapping("/blog")
    public String showListJquery() {
        return "listAppBlogJquery";
    }
}
