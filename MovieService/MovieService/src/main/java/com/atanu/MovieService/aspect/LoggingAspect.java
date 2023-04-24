package com.atanu.MovieService.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* com.atanu.MovieService..*(..))")
    public Object applyLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        String className=joinPoint.getSignature().getDeclaringType().getSimpleName();
        String methodName= joinPoint.getSignature().getName();
        System.out.println("In class "+className+" ,entering into method "+methodName);
        Object result=joinPoint.proceed();
        System.out.println("From class "+className+" ,coming out of method "+methodName);
        return result;
    }
}
