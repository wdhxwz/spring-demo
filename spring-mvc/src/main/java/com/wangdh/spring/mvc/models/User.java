package com.wangdh.spring.mvc.models;

/**
 * 用户类
 * 
 * @author wdhcxx
 *
 */
public class User {
	private String id;
	private String userName;

	public User() {

	}

	// public User(String id) {
	// this.id = id;
	// this.userName = "user-" + id;
	// }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}