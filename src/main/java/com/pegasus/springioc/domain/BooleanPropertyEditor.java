package com.pegasus.springioc.domain;

import java.beans.PropertyEditorSupport;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.pegasus.springioc.utils.PropertiesUtil;

public class BooleanPropertyEditor extends PropertyEditorSupport{

	@Override
	public String getAsText() {
		// TODO Auto-generated method stub
		return super.getAsText();
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		Resource resource=new ClassPathResource("./spring_ioc/user.properties");
		if(PropertiesUtil.matcher(text)) {
			String key =  PropertiesUtil.getKey(text);
			
			try {
				PropertiesUtil.load(resource.getInputStream());
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			Boolean sex= Boolean.parseBoolean(PropertiesUtil.get(key)) ;
			
			setValue(sex);
		}
	}

	
}
