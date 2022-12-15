package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterController {

    @RequestMapping("/converter-form")
public String showConverterForm(Model model){
    return "converter";
}
 @RequestMapping("/converter")
    public String converter(Model model, @RequestParam("usd") Double usd){
        model.addAttribute("usd",usd);
        model.addAttribute("vnd",usd*23000);
        return "converter";
 }

}
