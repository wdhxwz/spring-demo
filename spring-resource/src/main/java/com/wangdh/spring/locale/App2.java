package com.wangdh.spring.locale;

import java.util.GregorianCalendar;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring的资源本地化
 * @author wdhcxx
 *
 */
public class App2 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("i18n.xml");
		MessageSource messageSource = (MessageSource)context.getBean("messageSource");
		
		Locale en_US = new Locale("en", "US");
		// Locale zh_CN = new Locale("zh", "CN");
		
		Object[] params = {"John",new GregorianCalendar().getTime(),1.0E3};
		
		System.out.println(messageSource.getMessage("greeting.common", params, en_US));
		System.out.println(messageSource.getMessage("greeting.morning", params, en_US));
		System.out.println(messageSource.getMessage("greeting.afternoon", params, en_US));
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(context.getMessage("greeting.common", params, en_US));
		System.out.println(context.getMessage("greeting.morning", params, en_US));
		System.out.println(context.getMessage("greeting.afternoon", params, en_US));
	}
}