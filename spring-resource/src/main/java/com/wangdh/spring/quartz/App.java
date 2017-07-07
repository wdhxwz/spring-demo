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

	public static void main(String[] args) throws IOException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-job.xml");
		
		System.in.read();
	}
}
