package com.wangdh.spring.beanfactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**基于xml配置的Spring应用上下文测试
 * 
 * @author wdhcxx
 *
 */
public class ApplicationContextTest {

	public static void main(String[] args) {
		@SuppressWarnings({ "resource" })
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beanFactory.xml");

		Person person = applicationContext.getBean(Person.class);
		System.out.println(person.getName());
	}
}
