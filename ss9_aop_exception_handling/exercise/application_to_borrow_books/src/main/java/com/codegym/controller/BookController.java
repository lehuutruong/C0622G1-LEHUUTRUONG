package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.Oder;
import com.codegym.service.IBookService;
import com.codegym.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class BookController {
    @Autowired
    IBookService iBookService;
    @Autowired
    IOderService iOderService;

    @GetMapping("")
    public String index(@PageableDefault(value = 3) Pageable pageable, Model model) {
        Page<Book> books = iBookService.findAll(pageable);
        model.addAttribute("list", books);
        return "home";
    }

    @GetMapping("{id}/oder")
    public String oder(@PathVariable int id, Model model) {
        Oder oder = new Oder();

        int code = (int) (Math.random() * (99999 - 10000) + 10000);
        oder.setCode(code);

        int millis = (int) System.currentTimeMillis();
        oder.setDate(new java.sql.Date(millis));

        oder.setList(iBookService.findById(id));
        iOderService.save(oder);

        model.addAttribute("oder", oder);
        return "oder";
    }

    @PostMapping("/save")
    public String save(@PageableDefault(value = 3) Pageable pageable, @RequestParam int bookId, Model model) throws Exception {
        Book bookList = iBookService.findById(bookId);
        bookList.setCount(bookList.getCount() - 1);
        if (bookList.getCount() == -1) {
            throw new Exception();
        }
        Page<Book> books = iBookService.findAll(pageable);
        model.addAttribute("list", books);
        return "home";
    }

    @ExceptionHandler(Exception.class)
    public String handleError() {
        return "error";
    }
}
