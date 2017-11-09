package com.bjpowernode.hibernate;

import java.util.Set;

import com.bjpowernode.hibernate.ClientLevel;

/**
 * ∑÷œ˙…Ã
 * @author Administrator
 * 
 */
public class Client {

	private String id;
	
	private String name;
	
	private String bankAcctNo;
	
	private String contactTel;
	
	private String address;
	
	private String zipCode;
	
	private ClientLevel clientLevel;
	
	private Area area;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBankAcctNo() {
		return bankAcctNo;
	}

	public void setBankAcctNo(String bankAcctNo) {
		this.bankAcctNo = bankAcctNo;
	}

	public String getContactTel() {
		return contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public ClientLevel getClientLevel() {
		return clientLevel;
	}

	public void setClientLevel(ClientLevel clientLevel) {
		this.clientLevel = clientLevel;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

}
