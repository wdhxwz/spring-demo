package com.wangdh.spring.cache;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.wangdh.mybatis.mapper.UserEntityMapper;
import com.wangdh.mybatis.mapper.entity.UserEntity;

/**
 * Spring 集成Mybatis
 * @author wangdh
 * 2017年6月27日下午2:20:06
 */
public class SpringMybatisApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("mybatis.xml");
		UserEntityMapper userMapper = context.getBean(UserEntityMapper.class);
		PageHelper.startPage(1, 2);
		PageHelper.orderBy("id");
		List<UserEntity> users = userMapper.selectAll();
		for (UserEntity userEntity : users) {
			System.out.println(userEntity.getId());
		}
		
		context.close();
	}
}