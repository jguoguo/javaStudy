package com.bjpowernode.hibernate;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="t_classes")
public class Classes {
	private int id;
	private String name;
	//必须使用set，hibernate会扩展HashSet，会使用延迟加载
	private Set students;
	
	@Id
	@GeneratedValue
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
	
	//mappedBy在哪一端，哪一端不维护关系，它成为了关系的被管理端
	//相当于hibernatea中的inverse=true
	//如果采用了泛型，可以不采用targetEntity属性
	@OneToMany(mappedBy="classes",targetEntity=Student.class)
	@JoinColumn(name="classesid")//重命名列
	public Set getStudents() {
		return students;
	}
	public void setStudents(Set students) {
		this.students = students;
	}
	
}
