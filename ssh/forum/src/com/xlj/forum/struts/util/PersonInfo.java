package com.xlj.forum.struts.util;

import java.io.Serializable;

/**
 * 用于在Session中记录登录信息
 * @author Administrator
 *
 */
public class PersonInfo implements Serializable{
	private int id;//id
	private String account;//账号
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
