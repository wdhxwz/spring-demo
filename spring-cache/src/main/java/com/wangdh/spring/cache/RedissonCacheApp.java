package com.wangdh.spring.cache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wangdh.spring.cache.config.RedissonConfig;
import com.wangdh.spring.cache.service.UserService;

public class RedissonCacheApp {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(RedissonConfig.class);
		
//		// 清除缓存
//		RedissonClient redissonClient = context.getBean(RedissonClient.class);
//		RMap<String, User> rMap = redissonClient.getMap("users");
//		rMap.clear();
		
		UserService userService = context.getBean(UserService.class);
    	System.out.println(userService.getUser("1").toString());
    	System.out.println(userService.getUser("2").toString());
    	System.out.println(userService.getUser("1").toString());
    	System.out.println(userService.getUser("2").toString());
    	// userService.removeUser("123");
	}
}