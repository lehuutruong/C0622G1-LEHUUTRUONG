package com.using_thymeleaf_fo_product_management_app.controller;

import com.using_thymeleaf_fo_product_management_app.model.Product;
import com.using_thymeleaf_fo_product_management_app.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("")
    public String index(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("product", productList);
        return "index";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("mess", "Add success");
        return ("redirect:/product");
    }

    @GetMapping("{id}/edit")
    public String showUpdate(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return ("edit");
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        productService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("message", "Edit success");
        return "redirect:/product";
    }

    @GetMapping("{id}/delete")
    public String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return ("delete");
    }

    @PostMapping("/remove")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("messDelete", "Delete success");
        return "redirect:/product";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return ("view");
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam(value = "searchName",defaultValue = "") String name, Model model) {
        model.addAttribute("product", productService.findByName(name));
        return ("index");
    }
}
