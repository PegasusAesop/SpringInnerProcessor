package com.pegasus.springioc.domain;

public class OtherBean {

	private String id;
	private String name;
	private Integer age;
	private Boolean married;
	private Double salary;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Boolean getMarried() {
		return married;
	}
	public void setMarried(Boolean married) {
		this.married = married;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "OtherBean [id=" + id + ", name=" + name + ", age=" + age + ", married=" + married + ", salary=" + salary
				+ "]";
	}
	
}
