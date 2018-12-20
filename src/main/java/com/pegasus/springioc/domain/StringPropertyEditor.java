package com.pegasus.springioc.domain;

import java.beans.PropertyEditorSupport;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.pegasus.springioc.utils.PropertiesUtil;

public class StringPropertyEditor extends PropertyEditorSupport{

	@Override
	public String getAsText() {
		
		return super.getAsText();
	}

	@Override//${username}
	public void setAsText(String text) throws IllegalArgumentException {
		
		Resource resource=new ClassPathResource("./spring_ioc/user.properties");
		if(PropertiesUtil.matcher(text)) {
			String key =  PropertiesUtil.getKey(text);
			
			try {
				PropertiesUtil.load(resource.getInputStream());
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			String value = PropertiesUtil.get(key);
			
			setValue(value);
		}
	
	}

}









































