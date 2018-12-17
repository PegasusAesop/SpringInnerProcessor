package com.pegasus.springioc.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import com.pegasus.springioc.domain.HelloSpring;
import com.pegasus.springioc.domain.MyBean;
import com.pegasus.springioc.domain.SpringBean;
/**
 * 1两种IoC容器的创建过程
 * ApplicationContext
 * BeanFactory
 * @author hxs
 *
 */
@SuppressWarnings("deprecation")
public class Test {

	public static void main(String[] args) {
		//1获取IoC容器，读取配置文件，初始化Spring上下文；
		@SuppressWarnings("resource")
		ApplicationContext ac=new ClassPathXmlApplicationContext("./spring_ioc/applicationContext.xml");
		//2根据id,取出对应的对象；
		HelloSpring helloSpring = (HelloSpring) ac.getBean("helloSpring");
		System.out.println(helloSpring);
		//helloSpring.setName("Photon");
		helloSpring.show();
		
		Resource resource=new ClassPathResource("./spring_ioc/applicationContext.xml");
		BeanFactory bf= new XmlBeanFactory(resource);
		System.out.println(bf.getBean("helloSpring"));
		((HelloSpring) bf.getBean("helloSpring")).show();
		
		SpringBean springBean=(SpringBean) ac.getBean("springBean");
		springBean.show();
		
		MyBean myBean=(MyBean) ac.getBean("myBean");
		System.out.println(myBean);
		
	}
}
