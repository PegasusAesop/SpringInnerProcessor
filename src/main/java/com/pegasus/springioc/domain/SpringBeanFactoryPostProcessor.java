package com.pegasus.springioc.domain;

import java.beans.PropertyEditor;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class SpringBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	private Map<Class<?>,Class<? extends PropertyEditor>> customEditors;
	
	public Map<Class<?>, Class<? extends PropertyEditor>> getCustomEditors() {
		return customEditors;
	}

	public void setCustomEditors(Map<Class<?>, Class<? extends PropertyEditor>> customEditors) {
		this.customEditors = customEditors;
	}

	@Override
	//1向容器中注册属性编辑器，第一个参数表示要转换的属性类型，第二个参数表示要使用的属性编辑器；
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		
		System.out.println("SpringBeanFactoryPostProcessor");
		//beanFactory.registerCustomEditor(Address.class, AddressPropertyEditor.class);
		//beanFactory.registerCustomEditor(Date.class, DatePropertyEditor.class);
		for(Entry<Class<?>,Class<? extends PropertyEditor>> entry:customEditors.entrySet()) {
			
			beanFactory.registerCustomEditor(entry.getKey(), entry.getValue());
		}
		
	}
	
}
