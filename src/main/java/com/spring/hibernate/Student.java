package com.spring.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity		// to change name => @Entity(name="")
//@Table(name="")		// to keep the entity name as Student but table name as something else
public class Student {
	@Id		// to denote primary key
	private int id;
	
	private String name;
	private String city;
	
	private Certificate certi;
	
	public Certificate getCerti() {
		return certi;
	}

	public void setCerti(Certificate certi) {
		this.certi = certi;
	}

	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
	
	
}
