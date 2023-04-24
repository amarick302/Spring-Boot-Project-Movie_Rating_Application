package com.atanu.RatingService.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* com.atanu.RatingService..*(..))")
    public void beforeLogging(JoinPoint joinPoint){

        MethodSignature methodSignature= (MethodSignature) joinPoint.getSignature();
        String class_name=methodSignature.getDeclaringType().getSimpleName();
        String method_name=methodSignature.getName();
        System.out.println("Entering into class "+class_name+", and method "+method_name);
    }

    @After("execution(* com.atanu.RatingService..*(..))")
    public void afterLogging(JoinPoint joinPoint){

        MethodSignature methodSignature= (MethodSignature) joinPoint.getSignature();
        String class_name=methodSignature.getDeclaringType().getSimpleName();
        String method_name=methodSignature.getName();
        System.out.println("Come out from class "+class_name+", and method "+method_name);
    }
}
