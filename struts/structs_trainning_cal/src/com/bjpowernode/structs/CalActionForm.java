package com.bjpowernode.structs;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

@SuppressWarnings("serial")
public class CalActionForm extends ActionForm {
	private int value1;
	private String flag;
	private int value2;
	public int getValue1() {
		return value1;
	}
	public void setValue1(int value1) {
		this.value1 = value1;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public int getValue2() {
		return value2;
	}
	public void setValue2(int value2) {
		this.value2 = value2;
	}
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		System.out.println("-------------CalAction----------");
	}
	
}
