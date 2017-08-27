package com.wangdh.spring.jersey.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class MyJerseyApplication extends Application{

	/**
	 * 返回所有的根资源类列表
	 */
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> set = new HashSet<>();
		set.add(JerseyResource.class);
		
		// Spring集成Jersey
		set.add(RequestContextFilter.class);
		
		return set;
	}
}
