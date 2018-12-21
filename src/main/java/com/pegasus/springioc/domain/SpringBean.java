package com.pegasus.springioc.domain;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.core.io.Resource;

public class SpringBean {

	private String username;
	private Address address;
	private Date birthday;
	private Boolean sex;
	private Integer age;
	private Double salary;
	private LocalDate cretime;
	private Class<?> clazz;
	private Resource resource;
	private int id;
	private boolean married;

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public LocalDate getCretime() {
		return cretime;
	}

	public void setCretime(LocalDate cretime) {
		this.cretime = cretime;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

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
		return "SpringBean [username=" + username + ", address=" + address + ", birthday=" + birthday + ", sex=" + sex
				+ ", age=" + age + ", salary=" + salary + ", cretime=" + cretime + ", clazz=" + clazz + ", resource="
				+ resource + ", id=" + id + ", married=" + married + "]";
	}

	
}
