package com.bjpowernode.hibernate;

import java.util.Set;

public class Classes {
	private int id;
	private String name;
	//必须使用set，hibernate会扩展HashSet，会使用延迟加载
	private Set students;
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
	public Set getStudents() {
		return students;
	}
	public void setStudents(Set students) {
		this.students = students;
	}
	
}
