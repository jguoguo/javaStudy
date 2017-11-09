package com.xlj.struts.form;

import org.apache.struts.action.ActionForm;

import com.xlj.bean.Person;

public class TileForm extends ActionForm {

	private String action;
	private Person person=new Person();
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
}
