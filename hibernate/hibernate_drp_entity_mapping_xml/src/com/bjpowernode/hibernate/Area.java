package com.bjpowernode.hibernate;

import java.util.Set;

public class Area {

	private int id;
	
	private String name;
	
	private Area parent;
	
	private Set children;

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

	public Area getParent() {
		return parent;
	}

	public void setParent(Area parent) {
		this.parent = parent;
	}

	public Set getChildren() {
		return children;
	}

	public void setChildren(Set children) {
		this.children = children;
	} 
}
