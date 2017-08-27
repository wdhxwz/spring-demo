package com.wangdh.spring.mvc.config;

/**
 * spring会自动查找继承AbstractDispatcherServletInitializer的类用来配置servlet容器 <br/>
 * AbstractAnnotationConfigDispatcherServletInitializer继承了AbstractDispatcherServletInitializer
 * <br/>
 * 在Servlet 3.0 环境中，容器会在类路径中查找实现了javax.servlet.ServletContainerInitializer的类
 * <br/>
 * 如果发现已有实现类，就会调用它来配置Servlet容器 <br/>
 * 在Spring中，org.springframework.web.SpringServletContainerInitializer 类实现了该接口
 * <br/>
 * 同时这个类又会查找实现了org.springframework.web。WebApplicationInitializer接口的类 <br/>
 * 并将配置任务交给这些实现类去完成 <br/>
 * spring 提供一个便利的抽象类：AbstractAnnotationConfigDispatcherServletInitializer
 * 
 * @author wdhcxx
 *
 */
public class WebAppInitializer 
//extends AbstractAnnotationConfigDispatcherServletInitializer 
{
//	/**
//	 * 配置root上下文
//	 */
//	@Override
//	protected Class<?>[] getRootConfigClasses() {
//		return new Class<?>[] { RootConfig.class };
//	}
//
//	@Override
//	protected Class<?>[] getServletConfigClasses() {
//		return new Class<?>[] { WebAppConfig.class };
//	}
//
//	/**
//	 * 指定被servlet处理的url
//	 */
//	@Override
//	protected String[] getServletMappings() {
//		return new String[] { "/" };
//	}
}