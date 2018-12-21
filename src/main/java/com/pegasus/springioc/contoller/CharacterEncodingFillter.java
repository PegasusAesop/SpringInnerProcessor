package com.pegasus.springioc.contoller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import com.pegasus.springioc.utils.EncodingUtils;

/**
 * Servlet Filter implementation class EncodingFillter
 */
@WebFilter(filterName="character",
			value="/*",
			asyncSupported=true)
public class CharacterEncodingFillter implements Filter {
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("CharacterEncodingFilter is lauching...");
	}
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		
		//���ñ����ʽ
		//POST�����ǿ��Խ�����������ģ�
		//GET����ֻ�ܹ�һ��һ������
		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		response.setHeader("contextType", "text/html;charset=UTF-8");
//		���������൱�µ�������һ���Ч����
		response.setContentType("text/html;charset=UTF-8");
		

		// pass the request along the filter chain
		chain.doFilter(new MyHttpServletReqest(request), response);
	}

	/**
	 * decorator��ʽ�����ʽ��
	 * @author hxs
	 *
	 */
	private class MyHttpServletReqest extends HttpServletRequestWrapper{
		
		private HttpServletRequest request;
		public MyHttpServletReqest(HttpServletRequest request) {
			super(request);
			this.request=request;
		}
		
		public String getParameter(String name) {
			//��ȡ����ǰ����ķ�ʽ
			String method = request.getMethod();
			//��ȡ������ֵ
			String value=request.getParameter(name);
			
			if("GET".equalsIgnoreCase(method) && value!=null) {
				try {
//						System.out.println("value: "+EncodingUtils.getEncoding(value));
						if("GB2312".equals(EncodingUtils.getEncoding(value)) || "GBK".equals(EncodingUtils.getEncoding(value))) {
							return value;
						}
						value=new String(value.getBytes("ISO-8859-1"),request.getCharacterEncoding());
						
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return value;
		}
	}
}
