package com.wangdh.spring.cache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangdh.spring.cache.service.UserService;

public class EhcacheManagerApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("ehcaheApplicationContext.xml");
    	UserService userService = context.getBean(UserService.class);
    	System.out.println(userService.getUser("1").toString());
    	System.out.println(userService.getUser("2").toString());
    	System.out.println(userService.getUser("1").toString());
    	System.out.println(userService.getUser("2").toString());
    	System.out.println( "xml Config Test End" );
	}
}
