package com.wangdh.spring.mvc.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.wangdh.spring.mvc.models.User;
import com.wangdh.spring.mvc.service.UserService;

/**
 * 用户控制器
 * 
 * @author wdhcxx
 *
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@RequestMapping(value = "/{userId}")
	@ResponseBody
	public User getUser(@PathVariable("userId") String userId) {
		return userService.get(userId);
	}

	@ResponseBody
	@RequestMapping(value = "/aaa")
	public String aaa() {
		return "nimei";
	}

	@ResponseBody
	@RequestMapping(value = "/bbb")
	public int bbb(HttpServletRequest request) throws IOException {
		ServletInputStream ris = request.getInputStream();
		StringBuilder content = new StringBuilder();
		byte[] b = new byte[1024];
		int lens = -1;
		while ((lens = ris.read(b)) > 0) {
			content.append(new String(b, 0, lens));
		}
		String strcont = content.toString();
		logger.info(strcont);

		return 10;
	}

	@RequestMapping(value = "/ccc", method = { RequestMethod.POST })
	@ResponseBody
	public String ccc(@RequestParam("user") User user) {
		logger.info(user.getId() + ":" + user.getUserName());

		return "ccc";
	}


	@RequestMapping
	@ResponseBody
	public String test(Integer abc){
		return "测试一下" + abc;
	}

	@RequestMapping
	@ResponseBody
	public String test2(){
		return "测试2下";
	}

	@RequestMapping
	@ResponseBody
	public Object test3(){
		return new Date();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Object login(HttpServletRequest request,@RequestBody User user){
		Map<String,Object> map = new HashMap<>();
		logger.info("userName={},password={}",user.getUserName(),user.getPassword());
		if("wangdh".equals(user.getUserName())){
			map.put("code",200);
			map.put("data","123");
			map.put("message","登录成功");
		}else{
			map.put("code",401);
			map.put("data","");
			map.put("message","用户名或密码错误");
		}

		return  map;
	}
}