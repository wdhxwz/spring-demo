package com.wangdh.spring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PreGreetingAspect {
	@Before("execution(* greetTo(..))")
	public void beforeGreeting(){
		System.out.println("How are you");
	}
}
