package com.xlj.forum.struts.form;

import com.xlj.forum.bean.Person;

/**
 * personform����
 * @author Administrator
 *
 */
public class PersonForm extends ForumForm{
	private Person person=new Person();//person����
	private String password;
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
