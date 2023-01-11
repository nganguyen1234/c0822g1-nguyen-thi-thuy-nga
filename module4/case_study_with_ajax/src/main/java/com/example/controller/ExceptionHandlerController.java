package com.example.controller;

import org.springframework.expression.spel.SpelEvaluationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(NullPointerException.class)
    public String handleNullPointerException(){
        return "/errorPage/errorPage";
    }

    @ExceptionHandler(SpelEvaluationException.class)
    public String handleSpelEvaluationException(){
        return "/errorPage/errorPage";
    }
}
