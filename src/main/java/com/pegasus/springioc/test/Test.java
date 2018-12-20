package com.pegasus.springioc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pegasus.springioc.domain.SpringBean;

public class Test {

	public static void main(String[] args) {
		//1获取IoC容器，读取配置文件，初始化Spring上下文；
		@SuppressWarnings("resource")
		ApplicationContext ac=new ClassPathXmlApplicationContext("./spring_ioc/applicationContext.xml");
		SpringBean springBean=(SpringBean) ac.getBean("springBean");
		System.out.println(springBean);
	
		
	}
}
