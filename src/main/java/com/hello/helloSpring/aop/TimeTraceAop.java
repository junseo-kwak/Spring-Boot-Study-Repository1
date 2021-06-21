package com.hello.helloSpring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* com.hello.helloSpring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();

        System.out.println("START : " + joinPoint.toString());
        try{
            return joinPoint.proceed();
        }finally {
            long endTime = System.currentTimeMillis();
            long timeMs = endTime - startTime;

            System.out.println("END : " + joinPoint.toString() + " " + timeMs + "Ms" );
        }

    }
}
