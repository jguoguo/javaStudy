package com.xlj.forum.struts.util;

import java.io.Serializable;

/**
 * ������Session�м�¼��¼��Ϣ
 * @author Administrator
 *
 */
public class PersonInfo implements Serializable{
	private int id;//id
	private String account;//�˺�
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
}
