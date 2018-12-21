package com.pegasus.springioc.domain;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;

public class LocalDatePropertyEditor extends PropertyEditorSupport{

	@Override
	public String getAsText() {
		
		LocalDate localDate = (LocalDate) getValue();
	
		return localDate.toString();
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		LocalDate localDate = LocalDate.parse(text);
		setValue(localDate);
		
	}

}
