package com.wangdh.spring.propertyPlaceHolderConfigure;

public class JdbcConfig {
	private String url;
	private String classDriverName;
	private String password;
	private String userName;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getClassDriverName() {
		return classDriverName;
	}

	public void setClassDriverName(String classDriverName) {
		this.classDriverName = classDriverName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "url=" + url + ",classDriverName=" + classDriverName + ",password=" + password + ",userName=" + userName;
	}
}
