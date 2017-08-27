package com.wangdh.spring.mvc.converter;

import org.springframework.core.convert.converter.Converter;

import com.wangdh.spring.mvc.models.User;

/**
 * 将<userId>:<userName>类型的字符串转换成User对象
 * 
 * @author wdhcxx
 *
 */
public class StringToUserConverter implements Converter<String, User> {

	@Override
	public User convert(String source) {
		User user = new User();
		if (source != null && source.length() > 0) {
			String[] items = source.split(":");
			if (items.length > 1) {
				user.setId(items[0]);
				user.setUserName(items[1]);
			}
		}

		return user;
	}

}
