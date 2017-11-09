package com.xlj.hibernate.bean;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity					//@Entity��ʾ�����ܱ�Hibernate�־û�
@Table(name="tb_cat")	//ָ����Entity��Ӧ�����ݱ���
public class Cat {

	@Id												//ָ������Ϊ����
	@GeneratedValue(strategy=GenerationType.AUTO)	//�������ͣ�autoΪ����������
	private Integer id;
	
	@Column(name="name")//ָ�����Զ�Ӧ�����ݿ�����Ϊname
	private String name;
	
	@Column(name="description")//ͬ��
	private String description;
		
	@ManyToOne						//ָ��ʵ����֮��Ĺ�ϵ������Ϊ���һ��ϵ
	@JoinColumn(name="mother_id")	//�����Զ�Ӧ����
	private Cat mother;
	
	@Temporal(TemporalType.TIMESTAMP) //�������ͣ�DATE,TIME����TIMESTEMP)
	@Column(name="createDate")
	private Date createDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Cat getMother() {
		return mother;
	}

	public void setMother(Cat mother) {
		this.mother = mother;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
