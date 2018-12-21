package com.pegasus.springioc.domain;

import java.time.LocalDate;

public class MyBean {

	private String code;
	private String name;
	private LocalDate cretime;
	private Address address;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getCretime() {
		return cretime;
	}
	public void setCretime(LocalDate cretime) {
		this.cretime = cretime;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "MyBean [code=" + code + ", name=" + name + ", cretime=" + cretime + ", address=" + address + "]";
	}
	
	
}
