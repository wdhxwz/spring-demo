package com.wangdh.spring.quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SpringTaskService {

	/**
	 * 可配置多个属性：
	 * cron:每到什么时候执行一次
	 * fixedDelay:延时多少毫秒，多少毫秒执行一次
	 * fixedRate:为每隔一段时间执行一次
	 */
	@Scheduled(fixedDelay = 1000 * 3)
	public void task(){
		System.out.println("延迟3秒，每隔3秒执行一次:" + System.currentTimeMillis());
	}
	
	@Scheduled(fixedRate = 1000 * 5)
	public void task1(){
		System.out.println("每隔5秒执行一次:" + System.currentTimeMillis());
	}
	
	@Scheduled(cron = "0/2 * * * * *")
	public void task2(){
		System.out.println("cron每隔2秒执行一次:" + System.currentTimeMillis());
	}
}
