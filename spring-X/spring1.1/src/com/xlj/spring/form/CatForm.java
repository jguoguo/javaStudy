package com.xlj.spring.form;

import org.apache.struts.action.ActionForm;

public class CatForm extends ActionForm{
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	private String action;
	
}
