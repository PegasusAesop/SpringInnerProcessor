package com.pegasus.springioc.domain;

import java.beans.PropertyEditorSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressPropertyEditor extends PropertyEditorSupport{

	//1将对象中的属性值转化为字符串；
	@Override
	public String getAsText() {
		Address address=(Address) getValue();
		
		
		return "["+address.getCity()+"_"+address.getProvince()+"]";
	}

	//2.将字符串设置为对象中对应的属性值；
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String regex="\\[(.*)-(.*)\\]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		if(matcher.matches()) {
			String city=matcher.group(1);
			String province=matcher.group(2);
			Address address=new Address();
			address.setCity(city);
			address.setProvince(province);
			//1调用setValue方法设置值；
			setValue(address);
		}
	}


}
