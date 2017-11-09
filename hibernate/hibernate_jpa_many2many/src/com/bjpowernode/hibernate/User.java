package com.bjpowernode.hibernate;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="t_user")
public class User {
	private int id;
	private String name;
	private Set<Role> roles;
	
	@Id
	@GeneratedValue
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
	
	//��Ϊ����ʹ�÷��ͣ����Բ�ʹ��targetEntity��ָ������
	@ManyToMany
	@JoinTable(name="t_uer_role",
				joinColumns={@JoinColumn(name="user_id")},//����id
				inverseJoinColumns={@JoinColumn(name="role_id")}//�Զ�id
			)
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	
}
