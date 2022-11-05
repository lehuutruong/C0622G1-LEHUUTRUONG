package com.codegym.controller;

import com.codegym.dto.CartDto;
import com.codegym.dto.ProductDto;
import com.codegym.model.Product;
import com.codegym.service.impl.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@RequestMapping("/shop")
@SessionAttributes("cart")
public class ProductController {
    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @Autowired
    ProductService productService;

    @GetMapping("")
    public ModelAndView showHome(Model model, @CookieValue(value = "idProduct",defaultValue = "-1") int idProduct) {
//        if(idProduct!=-1){
//            model.addAttribute("historyProduct",productService.findById(idProduct).get());
//        }
        return new ModelAndView("product/list", "productList", productService.findAll());
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable int id, HttpServletResponse response) {
//         Cookie cookie=new Cookie("idProduct",id +" ");
//         cookie.setMaxAge(1*24*60*60);
//         cookie.setPath("/");
//         response.addCookie(cookie);
        ModelAndView modelAndView;
         modelAndView = new ModelAndView("/product/detail");
        Optional<Product> optionalProduct = productService.findById(id);
        if(optionalProduct.isPresent()) {
            modelAndView.addObject("productList", optionalProduct.get());
        } else {
            modelAndView = new ModelAndView("/product/list");
        }

        return modelAndView;
    }
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable int id,@SessionAttribute("cart") CartDto cart){
        Optional<Product> optionalProduct=productService.findById(id);
        if(optionalProduct.isPresent()){
            ProductDto productDto=new ProductDto();
            BeanUtils.copyProperties(optionalProduct.get(),productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }
}
