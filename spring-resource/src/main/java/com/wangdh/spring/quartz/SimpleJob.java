package com.wangdh.spring.quartz;

public class SimpleJob {
	public void doJob() {
		System.out.println(System.currentTimeMillis());
		System.out.println("不继承QuartzJobBean方式-调度进行中：" + System.currentTimeMillis());
	}
}