package com.wangdh.spring.beanfactory;

public class Person {
	public Person() {
		System.out.println("person init...");
	}
	
	private String  name;
	private int age;
	private int sex;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
}