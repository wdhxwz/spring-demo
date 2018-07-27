package com.wangdh.spring.mvc.controller;

import com.krista.extend.mvc.annotation.NoLog;
import com.krista.extend.mvc.annotation.RestRequestMapping;
import com.krista.extend.mvc.views.CaptchaView;
import com.krista.extend.mvc.views.DownloadView;
import com.krista.extend.mvc.views.JsonView;
import com.krista.extend.spring.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangdh.spring.mvc.service.TestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class GoController {
	private final Logger logger = LoggerFactory.getLogger(GoController.class);

	@RequestMapping(value = { "/" }, method = { RequestMethod.HEAD })
	public String head() {
		SpringUtil.getBean(TestService.class);
		return "go.jsp";
	}

	@RequestMapping(value = { "/", "/index" }, method = { RequestMethod.GET })
	public String index(Model model, HttpServletResponse response, HttpServletRequest request) {
		logger.info("====== processed by index ======");
		model.addAttribute("msg", "Go Go Go!");
        TestService testService = SpringUtil.getBean(TestService.class);
		testService.say();

		return "go";
	}

	@RequestMapping(value = { "/sayHello" }, method = { RequestMethod.GET })
	@ResponseBody
	@NoLog
	public String sayHello() {
		return "hello Spring Mvc";
	}

	@RestRequestMapping
	public String test(String userId, String name, Date date){
		return "userId=" + userId + ",name=" + name + ",date=" + date;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder){ ;
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
	}

	@RequestMapping
	public JsonView getJson(){
		return new JsonView("123");
	}

	@RequestMapping
	public DownloadView getFile(){
		return new DownloadView("C:\\Users\\Administrator\\Desktop\\2229444339yy.csv","test.cvs");
	}

	@RequestMapping
	public CaptchaView getCaptcha(){
		return new CaptchaView();
	}
}