package com.wangdh.spring.beanfactory;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * Bean工厂测试
 * @author wdhcxx
 *
 */
public class BeanFactoryTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource resource = resolver.getResource("beanFactory.xml");
		reader.loadBeanDefinitions(resource);
		
		Person person = factory.getBean(Person.class);
		System.out.println(person.getName());
		
		System.out.println("OK");
	}
}
