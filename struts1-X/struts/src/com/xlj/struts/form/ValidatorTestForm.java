package com.xlj.struts.form;

import org.apache.struts.validator.ValidatorForm;

public class ValidatorTestForm extends ValidatorForm {

	private int age;//年龄
	private String name;//姓名
	private String email;//电子邮件
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
