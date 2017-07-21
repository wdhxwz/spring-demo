package com.wangdh.spring.event;

import org.springframework.context.ApplicationListener;

/**
 * 邮件发送事件监听
 * 
 * @author wdhcxx
 *
 */
public class MailSendListener implements ApplicationListener<MailSendEvent> {

	@Override
	public void onApplicationEvent(MailSendEvent event) {
		System.out.println("MailSendListener:向" + event.getTo() + "发送完一封邮件");
	}
}
