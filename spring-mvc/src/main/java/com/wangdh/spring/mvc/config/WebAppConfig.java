package com.wangdh.spring.mvc.config;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangdh.spring.mvc.converter.StringToUserConverter;

/**
 * 配置Spring MVC
 * 
 * @author wdhcxx
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.wangdh.spring.mvc.controller" })
public class WebAppConfig extends WebMvcConfigurerAdapter {
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class); // 设置视图类型
		// viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	/**
	 * 配置转换器：将请求信息转换为字符串，以String类型返回数据
	 * 
	 * @return
	 */
	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter() {
		return new StringHttpMessageConverter(Charset.forName("UTF-8"));
	}

	/**
	 * 配置json转换器
	 * 
	 * @return
	 */
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
//		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
//		mappingJackson2HttpMessageConverter.setPrettyPrint(true);
//
//		return mappingJackson2HttpMessageConverter;
		return new MappingJackson2HttpMessageConverter () { 
			// 重写 writeInternal 方法，在返回内容前首先进行加密
			@Override
			protected void writeInternal (Object object, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException 
			{ 
				// 使用 Jackson 的 ObjectMapper 将 Java 对象转换成 Json String 
				ObjectMapper mapper = new ObjectMapper ();
				String json = mapper.writeValueAsString (object);
				// 加密 
				String result = json + "加密了！"; 
				// 输出 
				outputMessage.getBody ().write (result.getBytes ()); 
				} 
			}; 
	}

	/**
	 * 添加自定义类型转换器
	 */
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new StringToUserConverter());

		super.addFormatters(registry);
	}

	/**
	 * 文件上传配置
	 * 
	 * @return
	 */
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setDefaultEncoding("UTF-8");
		multipartResolver.setMaxUploadSize(1024 * 1024);

		return multipartResolver;
	}

	/**
	 * 直接匹配到视图，不需要经过控制器
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("/go.jsp");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		super.configureDefaultServletHandling(configurer);
		configurer.enable();
	}

	/**
	 * 静态资源处理器
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		registry.addResourceHandler("/resource/**").addResourceLocations("classpath:/META-INF/static");
	}

	/**
	 * 拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
	}

	/**
	 * 异常处理
	 */
	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();

		// 设置默认的错误视图
		simpleMappingExceptionResolver.setDefaultErrorView("/defaultException.jsp");

		// 设置异常在Model中保存的参数名，默认是exception
		simpleMappingExceptionResolver.setExceptionAttribute("ex");

		// 设置默认的响应码
		simpleMappingExceptionResolver.setDefaultStatusCode(200);

		// 配置解析出的viewName和statusCode的对应关系,key和value都是String类型
		Properties statusCodes = new Properties();
		statusCodes.setProperty("/aaa.jsp", "404");
		simpleMappingExceptionResolver.setStatusCodes(statusCodes);

		// 设置异常类(字符串)和viewName的对应关系，异常类可以是异常的一部分，也可以是异常父类的一部分
		Properties mappings = new Properties();
		mappings.put("ArithmeticException", "/aaa.jsp");
		simpleMappingExceptionResolver.setExceptionMappings(mappings);

		// 排除掉不处理的异常类型,精确匹配
		simpleMappingExceptionResolver.setExcludedExceptions(Exception.class, ArithmeticException.class);
		exceptionResolvers.add(simpleMappingExceptionResolver);

		super.configureHandlerExceptionResolvers(exceptionResolvers);
	}
}