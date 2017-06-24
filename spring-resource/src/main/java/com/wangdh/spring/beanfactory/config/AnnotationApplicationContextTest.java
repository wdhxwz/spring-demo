package com.wangdh.spring.beanfactory.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wangdh.spring.beanfactory.Person;

/**
 * 基于Java代码配置的Spring上下文测试
 * @author wdhcxx
 *
 */
public class AnnotationApplicationContextTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Beans.class);

		Person person = applicationContext.getBean(Person.class);
		System.out.println(person.getName());
	}
}
