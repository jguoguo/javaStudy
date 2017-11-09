package com.xlj.forum.bean;

import javax.persistence.*;

/**
 * ����
 * @author Administrator
 *
 */
@Entity
@Table
public class Reply extends BaseBean {
	@ManyToOne
	@JoinColumn(name="thread_id")//���
	private Thread thread;//�ظ�������
	
	private String title;//�ظ��ı���
	@Basic(fetch=FetchType.LAZY)//�ӳټ���
	@Column(columnDefinition="longtext")//����Ϊlongtext����
	private String context;//�ظ�������
	
	@ManyToOne
	@JoinColumn(name="author_id")//�����
	private Person author;//�ظ�����
	
	private int floor;//�ڼ�¥
	private String ipCreated;//����ʱ��IP��ַ
	
	
	
	
	public Thread getThread() {
		return thread;
	}
	public void setThread(Thread thread) {
		this.thread = thread;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Person getAuthor() {
		return author;
	}
	public void setAuthor(Person author) {
		this.author = author;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public String getIpCreated() {
		return ipCreated;
	}
	public void setIpCreated(String ipCreated) {
		this.ipCreated = ipCreated;
	}
	
	
	
	
}
