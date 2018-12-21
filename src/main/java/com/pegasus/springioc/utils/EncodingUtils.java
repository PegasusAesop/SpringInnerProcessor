package com.pegasus.springioc.utils;

public class EncodingUtils {

	public static String getEncoding(String value) {
		
		String encode = "GB2312";
		try {
			if (value.equals(new String(value.getBytes(encode), encode))) {
				String s = encode;
				return s;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		encode = "ISO-8859-1";
		
		try {
			if (value.equals(new String(value.getBytes(encode), encode))) {
			String s1 = encode;
			return s1;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		encode = "UTF-8";
		try {
			if (value.equals(new String(value.getBytes(encode), encode))) {
			String s2 = encode;
			return s2;
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		encode = "GBK";
		try {
			if (value.equals(new String(value.getBytes(encode), encode))) {
			String s3 = encode;
			return s3;
			}
		} catch (Exception e3) {
			e3.printStackTrace();
		}
		
		return "";
	}
}
