package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichCondimentsController {

@GetMapping("/display")
    public String displayView(){
        return "sandwichCondiments";
    }

    @GetMapping("/select")
    public String displaySelection(@RequestParam("condiment") String[] condiment, Model model){
model.addAttribute("condiment",condiment);
return "result";
    }
}
