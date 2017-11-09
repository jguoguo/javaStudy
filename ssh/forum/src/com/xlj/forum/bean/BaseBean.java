package com.xlj.forum.bean;

import java.util.Date;

import javax.persistence.*;

/**
 * ������
 * @author Administrator
 *
 */
@MappedSuperclass
public class BaseBean {
	@Id//ID����
	@GeneratedValue(strategy=GenerationType.AUTO)//�Զ�����
	private Integer id;
	
	@Version				//�汾��
	private Integer version;//hibernate�Զ�ά������
	
	private boolean deleted;//ɾ��λ��ʹ��Ĭ������
	@Temporal(value=TemporalType.TIMESTAMP)//ʱ���
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
