package com.mengya.bean;

public class Person {
	private String person_Id;

	private String person_name;

	private String person_age;

	private String person_address;

	public Person() {

	}

	public Person(String id, String name, String age, String address) {
		this.person_Id = id;
		this.person_name = name;
		this.person_age = age;
		this.person_address = address;
	}

	public String getPerson_address() {
		return person_address;
	}

	public void setPerson_address(String person_address) {
		this.person_address = person_address;
	}

	public String getPerson_age() {
		return person_age;
	}

	public void setPerson_age(String person_age) {
		this.person_age = person_age;
	}

	public String getPerson_Id() {
		return person_Id;
	}

	public void setPerson_Id(String person_Id) {
		this.person_Id = person_Id;
	}

	public String getPerson_name() {
		return person_name;
	}

	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}
}
