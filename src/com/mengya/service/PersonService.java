package com.mengya.service;

import java.util.ArrayList;
import java.util.List;

import com.mengya.bean.HxServiceRetreatReplacement;
import com.mengya.bean.Person;

public class PersonService {
	public List<Person> getAllPerson() {
		List<Person> perList = new ArrayList<Person>();
		perList.add(new Person("101", "小博", "22", "湖北"));
		perList.add(new Person("102", "张三", "21", "湖南"));
		perList.add(new Person("103", "李四", "23", "江苏"));
		perList.add(new Person("104", "王五", "22", "上海"));
		perList.add(new Person("101", "小博", "22", "湖北"));
		perList.add(new Person("102", "张三", "21", "湖南"));
		perList.add(new Person("103", "李四", "23", "江苏"));
		perList.add(new Person("104", "王五", "22", "上海"));
		perList.add(new Person("101", "小博", "22", "湖北"));
		perList.add(new Person("102", "张三", "21", "湖南"));
		perList.add(new Person("103", "李四", "23", "江苏"));
		perList.add(new Person("104", "王五", "22", "上海"));
		perList.add(new Person("101", "小博", "22", "湖北"));
		perList.add(new Person("102", "张三", "21", "湖南"));
		perList.add(new Person("103", "李四", "23", "江苏"));
		perList.add(new Person("104", "王五", "22", "上海"));
		perList.add(new Person("101", "小博", "22", "湖北"));
		perList.add(new Person("102", "张三", "21", "湖南"));
		perList.add(new Person("103", "李四", "23", "江苏"));
		perList.add(new Person("104", "王五", "22", "上海"));
		perList.add(new Person("101", "小博", "22", "湖北"));
		perList.add(new Person("102", "张三", "21", "湖南"));
		perList.add(new Person("103", "李四", "23", "江苏"));
		perList.add(new Person("104", "王五", "22", "上海"));
		return perList;
	}
	
	public List<HxServiceRetreatReplacement> getHxServiceRetreatReplacement() {
		List<HxServiceRetreatReplacement> perList = new ArrayList<HxServiceRetreatReplacement>();
		HxServiceRetreatReplacement  hr=new HxServiceRetreatReplacement();
		hr.setAccessory("xxx");
		hr.setCenterCheckComment("爱我的撒");
		hr.setDeliveryOrderNum("aa是的");
		perList.add(hr);
		return perList;
	}
}
