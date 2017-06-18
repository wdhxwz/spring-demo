package com.wangdh.spring.cache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangdh.spring.cache.config.SimpleCacheManagerConfig;
import com.wangdh.spring.cache.service.UserService;

/**
 * Hello world!
 *
 */
public class SimpleCacheManagerApp 
{
    public static void main( String[] args )
    {
    	// xmlConfig();
    	javaCodeConfig();
    }
    
    @SuppressWarnings("unused")
	private static void xmlConfig(){
    	@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	UserService userService = context.getBean(UserService.class);
    	System.out.println(userService.getUser("1").toString());
    	System.out.println(userService.getUser("2").toString());
    	System.out.println(userService.getUser("1").toString());
    	System.out.println(userService.getUser("2").toString());
    	System.out.println( "xml Config Test End" );
    }
    
    private static void javaCodeConfig(){
    	@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(SimpleCacheManagerConfig.class);
    	UserService userService = context.getBean(UserService.class);
    	System.out.println(userService.getUser("2").toString());
//    	System.out.println(userService.getUser("2").toString());
//    	userService.removeUser("2");
//    	userService.addUser("2");
//    	System.out.println(userService.getUser("2").toString());
    	System.out.println( "javaCode Config Test End" );
    }
}
