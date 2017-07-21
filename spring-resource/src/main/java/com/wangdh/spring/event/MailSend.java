package com.wangdh.spring.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 邮件发送事件源
 * @author wdhcxx
 *
 */
public class MailSend implements ApplicationContextAware{
	private ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}

	public void sendMail(String to){
		System.out.println("MailSend:模拟发送邮件...");
		MailSendEvent mailSendEvent = new MailSendEvent(context, to);
		context.publishEvent(mailSendEvent);
	}
}