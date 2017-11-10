package com.wangdh.websocket.spring;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * 配置root上下文
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebSocketConfig.class };
	}

	/**
	 * 指定被servlet处理的url
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}