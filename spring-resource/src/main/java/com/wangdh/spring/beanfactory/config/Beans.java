package com.wangdh.spring.beanfactory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wangdh.spring.beanfactory.Person;

/**
 * Spring应用上下文，Java 配置类
 * @author wdhcxx
 *
 */
@Configuration
public class Beans {

	@Bean
	public Person person(){
		Person person = new Person();
		person.setAge(25);
		person.setName("cxx");
		person.setSex(2);
		
		return person;
	}
}
