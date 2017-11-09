package com.bjpowernode.hibernate;

import java.util.Set;

public class Role {
	private int id;
	private String name;
	private Set Users;
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
	public Set getUsers() {
		return Users;
	}
	public void setUsers(Set users) {
		Users = users;
	}
	
	
}
