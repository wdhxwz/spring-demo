package com.wangdh.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exception")
public class ExceptionController {
	@RequestMapping("/simple")
	public String doException() {
		int i = 3 / 0;
		System.out.println(i);

		return "/showException.jsp";
	}
}
