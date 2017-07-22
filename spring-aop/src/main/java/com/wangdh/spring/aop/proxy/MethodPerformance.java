package com.wangdh.spring.aop.proxy;

public class MethodPerformance {
	private long begin;
	private long end;
	private String methodName;

	public MethodPerformance(String methodName) {
		this.methodName = methodName;
		this.begin = System.currentTimeMillis();
	}

	public void printPerformance() {
		this.end = System.currentTimeMillis();
		long elapse = end - begin;
		System.out.println(methodName + "花费" + elapse + "毫秒。");
	}
}
