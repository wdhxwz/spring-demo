package com.wangdh.spring.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangdh.spring.mvc.service.TestService;

@Controller
public class GoController {
	private final Logger logger = LoggerFactory.getLogger(GoController.class);

	@Autowired
	private TestService testService;

	@RequestMapping(value = { "/" }, method = { RequestMethod.HEAD })
	public String head() {
		return "go.jsp";
	}

	@RequestMapping(value = { "/", "/index" }, method = { RequestMethod.GET })
	public String index(Model model) {
		logger.info("====== processed by index ======");
		model.addAttribute("msg", "Go Go Go!");
		testService.say();

		return "go";
	}

	@RequestMapping(value = { "/sayHello" }, method = { RequestMethod.GET })
	@ResponseBody
	public String sayHello() {
		return "hello Spring Mvc";
	}
}
