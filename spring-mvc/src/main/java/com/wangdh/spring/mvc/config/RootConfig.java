package com.wangdh.spring.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.wangdh.spring.mvc.service" })
public class RootConfig {

}