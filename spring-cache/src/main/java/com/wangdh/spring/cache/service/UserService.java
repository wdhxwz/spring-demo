package com.wangdh.spring.cache.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.wangdh.spring.cache.entity.User;

/**
 * 
 * 
 * @author wangdh 2017年6月21日下午2:44:11
 */
@Service
@CacheConfig(cacheNames = { "FP:OAS:Biz:user:Test" })
public class UserService {
	private Map<String, User> userCache = new HashMap<>();
	{
		userCache.put("1", new User("1", "user1"));
		userCache.put("2", new User("2", "user2"));
	}

	@Autowired
	private CacheManager cacheManager;

	/**
	 * 事先将结果放到缓存管理器中
	 */
	@PostConstruct
	public void setup() {
		Cache usersCache = cacheManager.getCache("FP:OAS:Biz:user");
		for (Entry<String, User> entry : userCache.entrySet()) {
			usersCache.put(entry.getKey(), entry.getValue());
		}
	}

	/**
	 * @Cacheable ： 进行数据缓存，方法调用前执行 condition : 满足条件后进行缓存 unless :
	 *            满足条件不进行缓存,优先级高于condition
	 * @param id
	 * @return
	 */
	@Cacheable(key = "#id")
	public User getUser(String id) {
		System.out.println("get User with id=" + id);

		User user = userCache.get(id);
		if (user == null) {
			user = new User(id, "user-" + id);
		}

		return user;
	}

	/**
	 * @CacheEvict : 删除缓存，方法调用过后执行
	 * @param id
	 */
	@CacheEvict(allEntries = true)
	public void removeUser(String id) {
		System.out.println("remove User with id=" + id);
		userCache.remove(id);
	}

	/**
	 * @CachePut : 执行方法后将结果缓存,用于更新缓存
	 * @param user
	 */
	@CachePut(key = "#user.id")
	public void updateUser(User user) {

	}

	public void addUser(String id) {
		System.out.println("add User with id=" + id);
		userCache.put(id, new User(id, "user" + id));
	}
}