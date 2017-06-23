package com.wangdh.spring.boot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication springApplication = new SpringApplication(App.class);
    	springApplication.setBannerMode(Banner.Mode.OFF);
    	springApplication.run(args);
    }
}
