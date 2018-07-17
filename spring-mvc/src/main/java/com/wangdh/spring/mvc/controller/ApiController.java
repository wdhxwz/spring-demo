package com.wangdh.spring.mvc.controller;

import com.krista.extend.mvc.annotation.RestRequestMapping;
import com.wangdh.spring.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: dw_wanghonghong
 * @Date: 2018/7/16 14:35
 * @Description:
 */
@RequestMapping("/api")
@Controller
public class ApiController {
    @Autowired
    UserService userService;

    @RequestMapping
    public String index(){
        return "axios/Index";
    }

    @RestRequestMapping
    public Object getUser(String userId){
       return userService.get(userId);
    }
}