package com.hibernate.mapping.manytomany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Branch_manytomany")
public class Branch {

	@Id @GeneratedValue
	private int id;
	private String name;
	
	//@ManyToMany(mappedBy="branch")
	@ManyToMany
	private Collection<Student> students = new ArrayList<Student>();
	
	public int getId() {
		return id;
	}
	public Collection<Student> getStudents() {
		return students;
	}
	public void setStudents(Collection<Student> students) {
		this.students = students;
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
}
