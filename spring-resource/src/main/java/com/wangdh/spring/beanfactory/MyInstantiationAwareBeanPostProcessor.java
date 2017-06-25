package com.wangdh.spring.beanfactory;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

/**
 * 容器级生命周期接口
 * Instantiation : 实例化
 * @author wdhcxx
 *
 */
public class MyInstantiationAwareBeanPostProcessor 
	extends InstantiationAwareBeanPostProcessorAdapter{

	/**
	 * 实例化Bean之前调用
	 */
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		if("car".equals(beanName)){
			System.out.println("初始化Bean之前调用...");
		}
		
		return null;
	}

	/**
	 * 实例化bean后调用
	 */
	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		if("car".equals(beanName)){
			System.out.println("初始化Bean之后调用...");
		}
		
		return true;
	}

	/**
	 * 设置属性后调用
	 */
	@Override
	public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
			String beanName) throws BeansException {
		if("car".equals(beanName)){
			System.out.println("设置属性后调用...");
		}
		
		return super.postProcessPropertyValues(pvs, pds, bean, beanName);
	}	
}
