package com.pegasus.springioc.contoller;

import java.io.IOException;
import java.lang.reflect.Method;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// 1.获取表单中的路径后面带的参数method=方法名中的方法名
			String methodName = request.getParameter("method");
			//2如果获取的路径后面没有带method这个参数的话,就默认跳转到首页,具体原因请看后面的解释
			if (methodName == null || methodName.trim().isEmpty()) {
				//3把名称定为index,然后在这个类中写一个index方法;所有继承这个类的servlet都可以重写这个方法;
				methodName = "index";
			}
			/*
			* this为当前调用这个方法的类,即这个BaseServlet的子类,而不是指这个BaserServlet;谁调用谁就是这个this
			* this.getClass()获得当前这个类的对象 getMethod(方法名,后面的HttpServletRequest.class,
			* HttpServletResponse.class是固定参数,固定写法);
			*/
			//4获得方法对象
			Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			//5调用这个请求后处理的方法返回的字符串,指的是要转发还是重定向的路径(在子类servlet返回的)
			String text = (String) method.invoke(this, request, response);
			//6如果返回字符串为null,说明没有要求我做转发还是重定向,所以我什么都不用做
			if(text==null||text.trim().isEmpty()) {
				
				return;
			}
			 
			//7字符串.contains("子字符串")  字符串是否包含该子字符串 
			if(!text.contains(":")) {
				//8比如返回的是"/index.jsp"
				//9如果不包含,说明没规定要转发还是重定向,所以默认转发;记得一定要写forward
				request.getRequestDispatcher(text).forward(request, response);
			}else {
				//10比如text返回的是 "f:/index.jsp"  或 "r:"+request.getContextPath()+"/index.jsp"
				int index=text.indexOf(":");//如果有包含的话获取:在这个字符串中第一次出现的索引
				//11从0下标开始截取到:的前一个下标为止,(包前不包后) 获取标志f/r
				String flag = text.substring(0, index);//从字符串的0下标开始截取到指定的索引(包前不包后)
				//12从冒号的下标1+1为2的下标获取路径  /index.jsp 
				String path = text.substring(index+1);//13从指定索引开始截取字符串,直到末尾
				//14如果标志是f的话,就是要转发
				if (flag.equalsIgnoreCase("f")) {
					//15忽略大小写,比如F/f
					request.getRequestDispatcher(path).forward(request, response);//16一直忘了写forward
					//17如果标志是r的话,就是要重定向
				}else if (flag.equalsIgnoreCase("r")) {
					response.sendRedirect(path);
					}else {//18这个else可以不写的
						throw new RuntimeException("您的指令有误");
					}
				}
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
	}
 
	//19在BaseServlet中写index方法,那么继承他的所有servlet都可以重写该方法;
	//20这里主要是为了上面的第一个if语句默认跳转到首页准备的
	public String index(HttpServletRequest request,HttpServletResponse response) {
	 
		return null;
	}
 
 
}


