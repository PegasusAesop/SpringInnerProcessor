package com.pegasus.springioc.domain;

public class HelloSpring {

	private String name;
	private String address;
	private int age;
	private Byte sex;
	private boolean married;
	private Class<String> clazz;

	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public Byte getSex() {
		return sex;
	}



	public void setSex(Byte sex) {
		this.sex = sex;
	}



	public boolean isMarried() {
		return married;
	}



	public void setMarried(boolean married) {
		this.married = married;
	}



	public Class<String> getClazz() {
		return clazz;
	}



	public void setClazz(Class<String> clazz) {
		this.clazz = clazz;
	}



	public void show() {
		
		System.out.println("hello,"+this.name+" address: "+this.address);
	}



	@Override
	public String toString() {
		return "HelloSpring [name=" + name + ", address=" + address + ", age=" + age + ", sex=" + sex + ", married="
				+ married + ", clazz=" + clazz + "]";
	}

	

}
