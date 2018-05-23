package com.example.spring.data.jpa.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {
    @Before("execution(* com.example.spring.data.jpa.service.UserServiceImpl.*.*(..))")
    public void executeBefore() {
        System.out.println("################ Before advice");
    }
}
