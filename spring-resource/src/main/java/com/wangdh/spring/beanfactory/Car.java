package com.wangdh.spring.beanfactory;

/**
 * 管理Bean生命周期的接口
 * 
 * @author wdhcxx
 *
 */
public class Car {
	private String brand;
	private String color;
	private int maxSpeed;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		System.out.println("调用setBrand()设置属性");
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		System.out.println("调用setColor()设置属性");
		this.color = color;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		System.out.println("调用setMaxSpeed()设置属性");
		this.maxSpeed = maxSpeed;
	}

	public Car() {
		System.out.println("调用Car()构造函数");
	}

	public void introduce() {
		System.out.println("brand:" + brand + ",color:" + color + ",maxSpeed:" + maxSpeed);
	}
	
	public void init() {
		System.out.println("调用init-mehod所指定的init(),设置maxSpeed=240");
		this.maxSpeed = 240;
	}
	
	public void myDestroy(){
		System.out.println("调用destroy-mehod所指定的myDestroy()");
	}
}