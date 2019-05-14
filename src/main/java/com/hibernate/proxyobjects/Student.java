package com.hibernate.proxyobjects;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name="student_proxy")
public class Student {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String course;
	
	@ElementCollection(fetch=FetchType.EAGER)
	//@ElementCollection
	@JoinTable(name="STUDENT_ADDRESS", joinColumns=@JoinColumn(name="STUDNET_ID"))
	Collection<Address> listOfAddress = new ArrayList<Address>();

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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Collection<Address> getListOfAddress() {
		return listOfAddress;
	}

	public void setListOfAddress(Collection<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}

	
}
