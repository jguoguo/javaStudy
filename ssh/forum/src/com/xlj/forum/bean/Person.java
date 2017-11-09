package com.xlj.forum.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


/**
 * �û���
 * @author Administrator
 *
 */
@Entity//ʵ��������
@Table//�������
public class Person extends BaseBean {
	private String account;		//�˺�
	private String password;	//����
	private String sex;			//�Ա�
	private String name;		//����
	private String birthday;	//����
	private String email;		//�����ʼ�
	private String ipCreated;	//ע��ʱ��IP��ַ
	
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date dateLastActived;//���һ�ε�¼ʱ��
	
	private String ipLastActived;//���һ�ε�¼��IP
	@ManyToMany(mappedBy="administrators")//��Զ�����
	private Set<Board> boardsAdministrated=new HashSet<Board>();//����İ���
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
