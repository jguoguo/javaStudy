package com.bjpowernode.structs;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class StepActionForm extends ActionForm {

	private String name;
	private int[] productId;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getProductId() {
		return productId;
	}
	public void setProductId(int[] productId) {
		this.productId = productId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void resetForm(){
		this.name=null;
		this.productId=null;
		this.address=null;
	}
	
}
