package com.wangdh.spring.event;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class AppConfig {
	@Bean
	public MailSend mailSend(){
		return new MailSend();
	}
	
	@Bean
	public MailSendListener mailSendListener(){
		return new MailSendListener();
	}
}