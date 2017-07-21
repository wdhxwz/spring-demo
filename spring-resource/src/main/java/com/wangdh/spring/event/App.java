package com.wangdh.spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 事件测试
 * AbstractApplicationContext拥有一个ApplicationEventMulticaster成员，用于事件广播
 * @author wdhcxx
 *
 */
public class App {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		MailSend mailSend = context.getBean(MailSend.class);
		mailSend.sendMail("1366678737@qq.com");
	}
}
