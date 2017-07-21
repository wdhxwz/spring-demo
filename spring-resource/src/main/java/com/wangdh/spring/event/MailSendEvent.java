package com.wangdh.spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * 邮件发送时间
 * @author wdhcxx
 *
 */
public class MailSendEvent extends ApplicationContextEvent{
	private static final long serialVersionUID = 2238480115314647422L;
	private String to;
	
	public MailSendEvent(ApplicationContext source) {
		super(source);
		
	}
	
	public MailSendEvent(ApplicationContext source,String to) {
		super(source);
		this.to = to;
	}
	
	public String getTo(){
		return this.to;
	}
}