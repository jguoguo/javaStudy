package com.bjpowernode.hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Pig extends Animal {
	private int weight;

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
