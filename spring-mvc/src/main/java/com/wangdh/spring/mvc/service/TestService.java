package com.wangdh.spring.mvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("request")
public class TestService {
	private final Logger logger = LoggerFactory.getLogger(TestService.class);

	public TestService(){
	    logger.info("我被初始化了....");
    }

	public void say() {
		logger.info("enter TestService......");
		logger.info("hahaha...");
		logger.info("level TestService......");
	}
}