package com.wangdh.spring.propertyPlaceHolderConfigure;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:property.xml");
		JdbcConfig jdbcConfig = context.getBean(JdbcConfig.class);
		System.out.println(jdbcConfig.toString());
	}
}