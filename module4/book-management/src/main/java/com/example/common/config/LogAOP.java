package com.example.common.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class LogAOP {

    @Pointcut("execution(* com.example.controller.BookController.*Book(..))")
    public void callMethod() {
    }

    @Before("callMethod()")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("Bạn đang vào phương thức " + joinPoint.getSignature().getName() + ", time: " + LocalDateTime.now());
    }
}
