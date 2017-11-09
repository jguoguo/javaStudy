package com.xlj.forum.bean;


import java.util.Date;

import javax.persistence.*;


/**
 * 帖子
 * @author Administrator
 *
 */
@Entity
@Table
public class Thread extends BaseBean {
	@ManyToOne
	@JoinColumn(name="board_id")
	private Board board;//版面
	
	private String title;//标题
	
	@Basic(fetch=FetchType.LAZY)//延迟加载
	@Column(columnDefinition="longtext")//该列为longtext类型
	private String context;//内容
	
	@ManyToOne
	@JoinColumn(name="author_id")//外键
	private Person author;//作者
	
	private String ipCreated;//发表时的IP地址
	private int hit;//人气（点击率）
	
	@ManyToOne
	@JoinColumn(name="author_last_replied_id")//外键
	private Person authorLastReplied;//最后回复人
	
	@Temporal(TemporalType.TIMESTAMP)//时间戳类型
	private Date dataLastReplied;//最后回复时间
	
	private boolean readonly;//是否只读
	private boolean topped;//是否置顶
	private int replyCount;//回帖数
	
	
	
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
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
	public String getIpCreated() {
		return ipCreated;
	}
	public void setIpCreated(String ipCreated) {
		this.ipCreated = ipCreated;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Person getAuthorLastReplied() {
		return authorLastReplied;
	}
	public void setAuthorLastReplied(Person authorLastReplied) {
		this.authorLastReplied = authorLastReplied;
	}
	public Date getDataLastReplied() {
		return dataLastReplied;
	}
	public void setDataLastReplied(Date dataLastReplied) {
		this.dataLastReplied = dataLastReplied;
	}
	public boolean isReadonly() {
		return readonly;
	}
	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}
	public boolean isTopped() {
		return topped;
	}
	public void setTopped(boolean topped) {
		this.topped = topped;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	
	
	
}
