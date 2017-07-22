package com.wangdh.spring.aop.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class AppConfig {
	@Bean
	public Waiter waiter() {
		return new NativeWaiter();
	}
}