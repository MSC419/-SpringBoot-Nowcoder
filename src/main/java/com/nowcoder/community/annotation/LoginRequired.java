package com.nowcoder.community.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//有该注解的方法都是登陆后才能访问
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)//声明有效时期：程序运行时就有效
public @interface LoginRequired {
}
