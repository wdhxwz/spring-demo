package com.wangdh.spring.aop.cglib;

import com.wangdh.spring.aop.proxy.ForumServiceImpl;

public class App {
	public static void main(String[] args) {
		CglibProxy proxy = new CglibProxy();
		long begin = System.currentTimeMillis();
		ForumServiceImpl forumService = (ForumServiceImpl)proxy.getProxy(ForumServiceImpl.class);
		long end = System.currentTimeMillis();
		System.out.println(end - begin);
		forumService.removeTopic("444");
		forumService.removeForum("333");
	}
}
