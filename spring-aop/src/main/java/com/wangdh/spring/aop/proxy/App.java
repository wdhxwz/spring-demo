package com.wangdh.spring.aop.proxy;

import java.lang.reflect.Proxy;

public class App {

	public static void main(String[] args) {
		ForumService target = new ForumServiceImpl();
		PerformanceHandler handler = new PerformanceHandler(target);
		target.removeTopic("111");
		target.removeForum("222");

		long begin = System.currentTimeMillis();
		ForumService proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), handler);
		long end = System.currentTimeMillis();
		System.out.println(end - begin);
		proxy.removeTopic("100");
		proxy.removeForum("200");
	}
}
