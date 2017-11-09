package com.xlj.forum.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * 版面
 * @author Administrator
 *
 */
@Entity//实体类配置
@Table//表格配置
public class Board extends BaseBean {
	@ManyToOne
	@JoinColumn(name="category_id")//外键列
	private Category category;//版面类别
	
	private String name;//版面标题
	private String description;//版面描述
	private int threadCount;//帖子总数
	private int replyCount;//回帖总数
	
	@ManyToOne//多对一
	@JoinColumn(name="last_reply_id")//外键列
	private Reply lastReply;//最后发表的帖子
	
	@ManyToOne//多对一
	@JoinColumn(name="last_thread_id")//外键列
	private Thread lastThread;//最后发表的回帖
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="board_administrator",joinColumns={@JoinColumn(name="board_id")},inverseJoinColumns={@JoinColumn(name="person_id")})
	private Set<Person> administrators=new HashSet<Person>();

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public int getThreadCount() {
		return threadCount;
	}

	public void setThreadCount(int threadCount) {
		this.threadCount = threadCount;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public Reply getLastReply() {
		return lastReply;
	}

	public void setLastReply(Reply lastReply) {
		this.lastReply = lastReply;
	}

	public Thread getLastThread() {
		return lastThread;
	}

	public void setLastThread(Thread lastThread) {
		this.lastThread = lastThread;
	}

	public Set<Person> getAdministrators() {
		return administrators;
	}

	public void setAdministrators(Set<Person> administrators) {
		this.administrators = administrators;
	}
	
	
}
