package com.pegasus.springioc.domain;

import java.util.Date;

public class SpringBean {

	private String username;
	private Address address;
	private Date birthday;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "SpringBean [username=" + username + ", address=" + address + ", birthday=" + birthday + "]";
	}

}
