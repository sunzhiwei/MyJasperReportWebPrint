package com.mengya.service;

import java.util.ArrayList;
import java.util.List;

import com.mengya.bean.HxServiceRetreatReplacement;
import com.mengya.bean.Person;

public class PersonService {
	public List<Person> getAllPerson() {
		List<Person> perList = new ArrayList<Person>();
		perList.add(new Person("101", "С��", "22", "����"));
		perList.add(new Person("102", "����", "21", "����"));
		perList.add(new Person("103", "����", "23", "����"));
		perList.add(new Person("104", "����", "22", "�Ϻ�"));
		perList.add(new Person("101", "С��", "22", "����"));
		perList.add(new Person("102", "����", "21", "����"));
		perList.add(new Person("103", "����", "23", "����"));
		perList.add(new Person("104", "����", "22", "�Ϻ�"));
		perList.add(new Person("101", "С��", "22", "����"));
		perList.add(new Person("102", "����", "21", "����"));
		perList.add(new Person("103", "����", "23", "����"));
		perList.add(new Person("104", "����", "22", "�Ϻ�"));
		perList.add(new Person("101", "С��", "22", "����"));
		perList.add(new Person("102", "����", "21", "����"));
		perList.add(new Person("103", "����", "23", "����"));
		perList.add(new Person("104", "����", "22", "�Ϻ�"));
		perList.add(new Person("101", "С��", "22", "����"));
		perList.add(new Person("102", "����", "21", "����"));
		perList.add(new Person("103", "����", "23", "����"));
		perList.add(new Person("104", "����", "22", "�Ϻ�"));
		perList.add(new Person("101", "С��", "22", "����"));
		perList.add(new Person("102", "����", "21", "����"));
		perList.add(new Person("103", "����", "23", "����"));
		perList.add(new Person("104", "����", "22", "�Ϻ�"));
		return perList;
	}
	
	public List<HxServiceRetreatReplacement> getHxServiceRetreatReplacement() {
		List<HxServiceRetreatReplacement> perList = new ArrayList<HxServiceRetreatReplacement>();
		HxServiceRetreatReplacement  hr=new HxServiceRetreatReplacement();
		hr.setAccessory("xxx");
		hr.setCenterCheckComment("���ҵ���");
		hr.setDeliveryOrderNum("aa�ǵ�");
		perList.add(hr);
		return perList;
	}
}
