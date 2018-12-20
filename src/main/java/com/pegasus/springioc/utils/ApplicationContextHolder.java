package com.pegasus.springioc.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
/**
 * 
 * @author hxs
 *IoC容器工具类：获到并操作IoC容器；
 */
public class ApplicationContextHolder implements ApplicationContextAware{

	private static ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		
		System.out.println("ApplicationContext is injured into ApplicationContextHolder");
		ApplicationContextHolder.applicationContext=applicationContext;
	}

	//1通常情况下，不会直接让用户获得ApplicationContext容器，这样做太不安全了！
//	public static ApplicationContext getApplicationContext() {
//		
//		return applicationContext;
//	}
	//2根据id获取bean对象；
	public static Object getBean(String beanName) {
		
		return applicationContext.getBean(beanName);
	}
	//3.根据Class类型获得bean对象；
	public static<T> T getBean(Class<T> clazz) {
		
		return applicationContext.getBean(clazz);
		
	}
}
