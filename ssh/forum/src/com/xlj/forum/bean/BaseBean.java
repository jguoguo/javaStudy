package com.xlj.forum.bean;

import java.util.Date;

import javax.persistence.*;

/**
 * 基本类
 * @author Administrator
 *
 */
@MappedSuperclass
public class BaseBean {
	@Id//ID配置
	@GeneratedValue(strategy=GenerationType.AUTO)//自动增加
	private Integer id;
	
	@Version				//版本列
	private Integer version;//hibernate自动维护该列
	
	private boolean deleted;//删除位，使用默认配置
	@Temporal(value=TemporalType.TIMESTAMP)//时间戳
	private Date dateCreated;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
}
