package com.xlj.spring.orm;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="tb_cat")
public class Cat {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	@Temporal(value=TemporalType.TIMESTAMP)
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
