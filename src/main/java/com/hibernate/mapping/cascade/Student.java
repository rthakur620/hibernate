package com.hibernate.mapping.cascade;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Student_cascade")
public class Student {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="studentName")
	private String name;
	private String course;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private Collection<Branch> branch = new ArrayList<Branch>();
	// Inverse relationship can also be done , we can put in Branch @ManyToOne
	
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
