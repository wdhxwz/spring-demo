package com.wangdh.spring.mvc.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.wangdh.spring.mvc.models.User;

/**
 * 用户服务类
 * 
 * @author wdhcxx
 *
 */
@Service
public class UserService {

	private static Map<String, User> users = new HashMap<String, User>();

	static {
		users.put("1", new User());
		users.put("2", new User());
	}

	public User get(String userId) {
		return users.get(userId);
	}
}
