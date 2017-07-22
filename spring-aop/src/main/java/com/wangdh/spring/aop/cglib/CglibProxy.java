package com.wangdh.spring.aop.cglib;

import java.lang.reflect.Method;

import com.wangdh.spring.aop.proxy.PerformanceMonitor;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

	private Enhancer enhancer = new Enhancer();

	public Object getProxy(Class<?> clazz) {
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);

		return enhancer.create();
	}

	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		PerformanceMonitor.begin(object.getClass().getName()+"."+method.getName());
		Object result = methodProxy.invokeSuper(object, args);
		PerformanceMonitor.end();
		return result;
	}

}
