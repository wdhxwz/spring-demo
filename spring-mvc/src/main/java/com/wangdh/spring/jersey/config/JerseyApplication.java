package com.wangdh.spring.jersey.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/**
 * Jersey相关配置
 * @author wdhcxx
 *
 */
public class JerseyApplication extends ResourceConfig{

	/**
	 * 注册JAX-RS相关组件
	 */
	public JerseyApplication(){
		// Spring集成Jersey
		register(RequestContextFilter.class);
		register(CustomExceptionMapper.class);
		register(JerseyResource.class);
	}
}
