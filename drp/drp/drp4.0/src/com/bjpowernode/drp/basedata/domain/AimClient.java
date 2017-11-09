package com.bjpowernode.drp.basedata.domain;

public class AimClient {
	//id
	private int id;
	//分销商或终端name
	private String name;
	//分销商或终端ID
	private String clienttemiId;
	//分销商或终端级别ID
	private String clienttemiLevelId;
	//分销商或终端级别name
	private String clienttemiLevelName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClienttemiId() {
		return clienttemiId;
	}
	public void setClienttemiId(String clienttemiId) {
		this.clienttemiId = clienttemiId;
	}
	public String getClienttemiLevelId() {
		return clienttemiLevelId;
	}
	public void setClienttemiLevelId(String clienttemiLevelId) {
		this.clienttemiLevelId = clienttemiLevelId;
	}
	public String getClienttemiLevelName() {
		return clienttemiLevelName;
	}
	public void setClienttemiLevelName(String clienttemiLevelName) {
		this.clienttemiLevelName = clienttemiLevelName;
	}
	
}
