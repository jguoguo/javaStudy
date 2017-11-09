package com.bjpowernode.drp.util;

public class JdbcConfig {
	private String driverName;
	private String url;
	private String userName;
	private String password;
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getClass().getName()+"{driverName:"+driverName+" url:"+url+" userName:"+userName+"}";
	}
	
	
	
}
