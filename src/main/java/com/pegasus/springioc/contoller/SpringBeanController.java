package com.pegasus.springioc.contoller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pegasus.springioc.domain.MyBean;

@WebServlet("/springBean.do")
public class SpringBeanController extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("register is launching.");
		Enumeration<String> parameterNames = request.getParameterNames();
		Map<String,String > container=new HashMap<>();
		
		while(parameterNames.hasMoreElements()) {
			String key=parameterNames.nextElement();
			String value=request.getParameter(key);
			container.put(key, value);
		}
		
		
		@SuppressWarnings("resource")
		ApplicationContext ac=new ClassPathXmlApplicationContext("./web/applicationContext.xml");
		MyBean myBean=(MyBean) ac.getBean("myBean");
		System.out.println(myBean);
		
		container.forEach((str1,str2) ->System.out.println(str1+str2) );
		
		/*for(Map.Entry<String, String> result:container.entrySet()) {
			
			System.out.println(result.getKey()+"___"+result.getValue());
		}*/
	}
}
