package com.bjpowernode.hibernate;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_role")
public class Role {
	private int id;
	private String name;
	private Set<User> Users;
	
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
	@ManyToMany(mappedBy="roles")
	public Set<User> getUsers() {
		return Users;
	}
	public void setUsers(Set<User> users) {
		Users = users;
	}
	
	
}
