package com.xlj.listener.singleton;

import java.io.Serializable;
import java.util.Date;

public class PersonInfo implements Serializable {

	private String account;
	private String ip;
	private Date loginDate;
	
	
	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}


	public Date getLoginDate() {
		return loginDate;
	}


	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}


	public boolean equals(Object obj){//¸²¸Çequals()
		if(obj==null || !(obj instanceof PersonInfo)){
			return false;
		}
		return account.equalsIgnoreCase(((PersonInfo)obj).getAccount());
	}
}
