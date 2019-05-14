package com.hibernate.mapping.manytomany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="Student_manytomany")
public class Student {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="studentName")
	private String name;
	private String course;
	
	@ManyToMany
	private Collection<Branch> branch = new ArrayList<Branch>();
	
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
	
	public Collection<Branch> getBranch() {
		return branch;
	}
	public void setBranch(Collection<Branch> branch) {
		this.branch = branch;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + "]";
	}
	
	
	
}
