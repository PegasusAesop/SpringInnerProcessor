package com.pegasus.springioc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertiesUtil {

	private static Properties prop;
	
	/**
	 * 
	 * @param inputStream
	 */
	public static void load(InputStream inputStream) {
		
		if(prop==null) {
			prop = new Properties();
		}
		
		try {
			prop.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 根据key取value值；
	 * @param key
	 * @return
	 */
	public static String get(String key) {
		
		return prop.containsKey(key) ? prop.get(key).toString():"";
		
	}
	
	/**
	 * 判断是否有符合的key字符串?
	 */
	public static boolean matcher(String str) {
		
		Pattern pattern = Pattern.compile("\\$\\{(.*)\\}");
		Matcher matcher = pattern.matcher(str);
		
		return matcher.matches();
	}
	/**
	 * 从key字符串中取出key值；
	 * @param str
	 * @return
	 */
	public static String getKey(String str) {
		
		Pattern pattern = Pattern.compile("\\$\\{(.*)\\}");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches() ? matcher.group(1) : "";
	}
	
}
