package com.pegasus.springioc.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MyBean {

	private Integer[] array;
	private List<String> list;
	private List<YourBean> lists;
	
	public List<YourBean> getLists() {
		return lists;
	}
	public void setLists(List<YourBean> lists) {
		this.lists = lists;
	}
	private Set<Double> set;
	private Map<String,Double> map;
	private Map<YourBean,Integer> maps;
	
	private Properties properties;
	
	public Integer[] getArray() {
		return array;
	}
	public void setArray(Integer[] array) {
		this.array = array;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public Set<Double> getSet() {
		return set;
	}
	public void setSet(Set<Double> set) {
		this.set = set;
	}
	public Map<String, Double> getMap() {
		return map;
	}
	public void setMap(Map<String, Double> map) {
		this.map = map;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public Map<YourBean, Integer> getMaps() {
		return maps;
	}
	public void setMaps(Map<YourBean, Integer> maps) {
		this.maps = maps;
	}
	@Override
	public String toString() {
		return "MyBean [array=" + Arrays.toString(array) + ", list=" + list + ", lists=" + lists + ", set=" + set
				+ ", map=" + map + ", maps=" + maps + ", properties=" + properties + "]";
	}
	
}
