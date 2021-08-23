package com.nowcoder.community.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Component//声明为Bean
//@Aspect//声明为Aspect组件
public class AlphaAspect {
    @Pointcut("execution(* com.nowcoder.community.service.*.*(..))")
    //切点,第一个*表示方法的返回值，后面两个*表示包名下的所有类的所有方法，(..)表示方法里所有的参数
    public void pointcut(){

    }
    //在连接点之前做一些事情
    @Before("pointcut()")
    public void before(){
        System.out.println("before");
    }

    //在连接点后面做一些事情
    @After("pointcut()")
    public void after(){
        System.out.println("after");
    }

    //在返回值以后做一些事情
    @AfterReturning("pointcut()")
    public void afterReturning(){
        System.out.println("afterReturning");
    }
    //在抛出异常以后做一些事情
    @AfterThrowing("pointcut()")
    public void afterThrowing(){
        System.out.println("afterThrowing");
    }
    //在前后
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("around-before");
        Object obj = joinPoint.proceed();
        System.out.println("around-after");
        return obj;
    }
}
