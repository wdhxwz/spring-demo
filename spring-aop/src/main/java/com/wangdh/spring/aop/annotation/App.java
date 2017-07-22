package com.wangdh.spring.aop.annotation;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		Waiter target = new NativeWaiter();
		AspectJProxyFactory factory = new AspectJProxyFactory();
		factory.setTarget(target);
		factory.addAspect(PreGreetingAspect.class);
		Waiter proxy = factory.getProxy();
		proxy.greetTo("wangdh");
		proxy.serverTo("wangdh");
		
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Waiter waiter = context.getBean(Waiter.class);
		waiter.greetTo("cxx");
		waiter.serverTo("cxx");
	}
}