package com.atanu.userService.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.atanu.userService..*(..))")
    public void applyAdviceBeforeMethodInvoking(JoinPoint joinPoint){
        String class_name = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String method_name = joinPoint.getSignature().getName();
        System.out.println("In Class "+class_name+", enter into method "+method_name);
    }

    @After("execution(* com.atanu.userService..*(..))")
    public void applyAdviceAfterMethodInvoking(JoinPoint joinPoint){
        String class_name = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String method_name = joinPoint.getSignature().getName();
        System.out.println("From Class "+class_name+", from the method "+method_name);
    }
}
