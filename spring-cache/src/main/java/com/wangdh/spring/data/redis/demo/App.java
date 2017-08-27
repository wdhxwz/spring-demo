package com.wangdh.spring.data.redis.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

public class App {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RedisConfig.class);
		JedisConnectionFactory connectionFactory = context.getBean(JedisConnectionFactory.class);
		
		String key = "date";
		String value = "2017-08-13";
		
		connectionFactory.getConnection().set(key.getBytes(), value.getBytes());
		
		
		@SuppressWarnings("unchecked")
		RedisTemplate<String, String> template = context.getBean(RedisTemplate.class);
		template.boundValueOps("wangdh:name").set("nima");
		
		template.boundHashOps("person").put("name", "wangdh");
		template.boundHashOps("person").put("age", "26");
		
		context.destroy();
		
		System.out.println("OK");
	}

}
