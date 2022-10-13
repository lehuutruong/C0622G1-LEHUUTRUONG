package currency_converter_app.controller;

import currency_converter_app.service.ICurrencyConverterApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConverterApp {
    @Autowired
    ICurrencyConverterApp currencyConverterApp;
    @GetMapping
    public String changeMoney() {
        return "views";
    }
    @PostMapping("/result")
    public String result(@RequestParam double vnd,@RequestParam double rate, Model model){
        model.addAttribute("vnd",vnd);
        model.addAttribute("rate",rate);
        model.addAttribute("usd",currencyConverterApp.changeMoney(vnd,rate));
        return "views";
    }
}
