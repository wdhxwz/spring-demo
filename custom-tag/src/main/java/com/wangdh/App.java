package com.wangdh;

import com.wangdh.custom.tag.defination.UserDefination;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDefination user = (UserDefination) context.getBean("user");

        Map map = context.getBeansOfType(UserDefination.class);


        
        System.out.println(user.toString());
    }
}
