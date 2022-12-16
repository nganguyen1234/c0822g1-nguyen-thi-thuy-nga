package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.ws.RequestWrapper;

@Controller
public class CalculatorController {

    @GetMapping("/display")
    public String displayCalculator() {
        return "calculator";
    }

    @GetMapping("/calculate")
    public String calculate(Model model, @RequestParam("num1") int num1, @RequestParam("num2") int num2, @RequestParam("operator") String operator) {
        String result = null;
        switch (operator) {
            case "Addition(+)":
                result = String.valueOf(num1 + num2);
                break;
            case "Subtraction(-)":
                result = String.valueOf(num1 - num2);
                break;
            case "Multiplication(*)":
                result = String.valueOf(num1 * num2);
                break;
            case "Division(/)":
                if (num2==0){
                    result = "không thể chia cho 0";
                } else {
                    result = String.valueOf(num1 / num2);
                }
                break;
            default:
                result = null;
        }
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("result", result);
        return "calculator";
    }
}
