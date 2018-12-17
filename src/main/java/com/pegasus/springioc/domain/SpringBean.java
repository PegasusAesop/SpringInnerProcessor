package com.pegasus.springioc.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SpringBean {

	private String username;
	private String password;
	private String email;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "SpringBean [username=" + username + ", password=" + password + ", email=" + email + "]";
	}
	//1初始化方法粉末登场！
	public void init() {
		
		this.username=reValue(this.username);
		this.password=reValue(this.password);
		this.email=reValue(this.email);
		
	}
	private String reValue(String value) {
		// TODO Auto-generated method stub
		
		if(value==null || "".equals(value)) {
			
			return value;
		}
		//2.0方法一：字符串截取法：
		/*else if(value.startsWith("$") && value.endsWith("}")) {
			
			String key=value.substring(2,value.length()-1);
			
			return getPropery(key);
		}*/
		
		//2.1方法二：正则表达式
		//"{(.*)}":.0任意字符，*任意个数量；()：分组表示；
		String regex="\\$\\{(.*)\\}";
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);
		if(matcher.matches()) {//1判断是否匹配上了？
			String key = matcher.group(1);
			
			return getPropery(key);
			
/*			try {
				return Files
						 .lines(Paths
						 .get("E:/0ZSET_SOURCES/SPRING_ARTICLE/SpringIoC2/src/main/resources/spring_ioc/user.properties"))
						 .map(str -> str.split("="))
						 .collect(Collectors.toMap(s -> s[0], s -> s[1]))
						 .get(key);
						 
			} catch (IOException e) {
				
				e.printStackTrace();
			}*/
		}
		
		return value;
	}
	
	//3根据key取得value;
	private String getPropery(String key) {
		// TODO Auto-generated method stub
		Properties p=new Properties();
		try {
			p.load(SpringBean.class.getClassLoader().getResourceAsStream("./spring_ioc/user.properties"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(p.containsKey(key)) {
	
			return p.getProperty(key);
			
		}else
			throw new RuntimeException("NO KEY :"+key +".");
	}
}
