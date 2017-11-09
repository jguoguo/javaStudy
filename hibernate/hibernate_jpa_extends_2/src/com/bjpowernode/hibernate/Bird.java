package com.bjpowernode.hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Bird extends Animal {
	private int height;

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
