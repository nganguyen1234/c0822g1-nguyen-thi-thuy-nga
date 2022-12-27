package com.example.controller;

import com.example.common.exception.InvalidCodeException;
import com.example.common.exception.OutOfBookException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(InvalidCodeException.class)
    public String errorPage() {
        return "error_page/invalidCodeHandler";
    }

    @ExceptionHandler(OutOfBookException.class)
    public String errorPage1() {
        return "error_page/outOfBookHandler";
    }
}
