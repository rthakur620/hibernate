package com.hibernate.namedquery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQuery(name="Student.byId", query="from Student where id=?")
@NamedNativeQuery(name="Student.byName", query="select * from student_named where studentName=?", resultClass=Student.class)
@Table(name="Student_named")
public class Student {

	@Id @GeneratedValue
	private int id;
	
	@Column(name="studentName")
	private String name;
	private String course;
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
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + "]";
	}
	
	
}
