package com.bjpowernode.drp;

public class JdbcInfo {
	@Override
	public String toString(){
		return this.getClass().getName()+"{driverName="+this.dirverName+
				",url="+this.url+
				",username="+this.username+
				",password="+this.password+"}";
	}
	private String dirverName;
	private String url;
	private String username;
	private String password;
	public String getDirverName() {
		return dirverName;
	}
	public void setDirverName(String dirverName) {
		this.dirverName = dirverName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
