package com.pegasus.springioc.domain;

public class YourBean {

	private String name;
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "YourBean [name=" + name + "]";
	}
	
}
