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
		//1传统方式读取文件流；
		//InputStream inputStream = StringPropertyEditor.class.getClassLoader().getResourceAsStream("./spring_ioc/user.properties");
		
		//2Resource 方式读取文件流；
		Resource resource=new ClassPathResource("./spring_ioc/user.properties");
		if(PropertiesUtil.matcher(text)) {
			String key =  PropertiesUtil.getKey(text);
			
			try {
				//PropertiesUtil.load(inputStream);
				PropertiesUtil.load(resource.getInputStream());
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			String value = PropertiesUtil.get(key);
			
			setValue(value);
		}
	
	}

}









































