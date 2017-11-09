package com.xlj.forum.bean;

import javax.persistence.*;

/**
 * 回帖
 * @author Administrator
 *
 */
@Entity
@Table
public class Reply extends BaseBean {
	@ManyToOne
	@JoinColumn(name="thread_id")//外键
	private Thread thread;//回复的帖子
	
	private String title;//回复的标题
	@Basic(fetch=FetchType.LAZY)//延迟加载
	@Column(columnDefinition="longtext")//该列为longtext类型
	private String context;//回复的内容
	
	@ManyToOne
	@JoinColumn(name="author_id")//外键列
	private Person author;//回复作者
	
	private int floor;//第几楼
	private String ipCreated;//发表时的IP地址
	
	
	
	
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
