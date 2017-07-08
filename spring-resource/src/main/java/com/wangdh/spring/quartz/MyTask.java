package com.wangdh.spring.quartz;

public class MyTask {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void run() {
		System.out.println("Run task: " + name + "." + System.currentTimeMillis());
	}
}