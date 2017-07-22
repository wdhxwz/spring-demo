package com.wangdh.spring.aop.annotation;

public class NativeWaiter implements Waiter {

	@Override
	public void greetTo(String clientName) {
		System.out.println("NativeWaiter:greet to " + clientName + "...");
	}

	@Override
	public void serverTo(String clientName) {
		System.out.println("NativeWaiter:server to " + clientName + "...");
	}
}
