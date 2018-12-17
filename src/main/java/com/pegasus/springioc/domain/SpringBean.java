package com.pegasus.springioc.domain;

public class SpringBean {

	private OtherBean otherBean;

	public OtherBean getOtherBean() {
		return otherBean;
	}

	public void setOtherBean(OtherBean otherBean) {
		this.otherBean = otherBean;
	}
	
	public void show() {
		
		System.out.println(this.otherBean);
	}
}
