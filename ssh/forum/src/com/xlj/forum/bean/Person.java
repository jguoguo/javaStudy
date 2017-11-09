package com.xlj.forum.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


/**
 * 用户类
 * @author Administrator
 *
 */
@Entity//实体类配置
@Table//表格配置
public class Person extends BaseBean {
	private String account;		//账号
	private String password;	//密码
	private String sex;			//性别
	private String name;		//姓名
	private String birthday;	//生日
	private String email;		//电子邮件
	private String ipCreated;	//注册时的IP地址
	
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date dateLastActived;//最后一次登录时间
	
	private String ipLastActived;//最后一次登录的IP
	@ManyToMany(mappedBy="administrators")//多对多属性
	private Set<Board> boardsAdministrated=new HashSet<Board>();//管理的版面
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIpCreated() {
		return ipCreated;
	}
	public void setIpCreated(String ipCreated) {
		this.ipCreated = ipCreated;
	}
	public Date getDateLastActived() {
		return dateLastActived;
	}
	public void setDateLastActived(Date dateLastActived) {
		this.dateLastActived = dateLastActived;
	}
	public String getIpLastActived() {
		return ipLastActived;
	}
	public void setIpLastActived(String ipLastActived) {
		this.ipLastActived = ipLastActived;
	}
	public Set<Board> getBoardsAdministrated() {
		return boardsAdministrated;
	}
	public void setBoardsAdministrated(Set<Board> boardsAdministrated) {
		this.boardsAdministrated = boardsAdministrated;
	}
	
	
	
}
