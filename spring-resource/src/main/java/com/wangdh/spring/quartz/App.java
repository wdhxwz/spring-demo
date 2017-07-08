package com.wangdh.spring.quartz;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 任务调度测试
 * @author wangdh
 * 2017年7月7日上午11:40:39
 */
public class App {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("unused")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-job.xml");
		
		System.in.read();
	}
}
