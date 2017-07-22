package com.wangdh.spring.aop.proxy;

public class PerformanceMonitor {
	private static ThreadLocal<MethodPerformance> performanceRecord = new ThreadLocal<MethodPerformance>();
	
	public static void begin(String method){
		System.out.println("begin monitor...");
		MethodPerformance methodPerformance = new MethodPerformance(method);
		performanceRecord.set(methodPerformance);
	}
	
	public static void end(){
		System.out.println("end monitor...");
		MethodPerformance methodPerformance = performanceRecord.get();
		methodPerformance.printPerformance();
	}
}
