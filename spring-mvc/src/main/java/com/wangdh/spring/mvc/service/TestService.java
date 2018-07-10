package com.wangdh.spring.mvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	private final Logger logger = LoggerFactory.getLogger(TestService.class);

	public void say() {
		logger.info("enter TestService......");
		logger.info("hahaha...");
		logger.info("level TestService......");
	}
}