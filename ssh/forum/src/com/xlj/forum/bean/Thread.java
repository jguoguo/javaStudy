package com.xlj.forum.bean;


import java.util.Date;

import javax.persistence.*;


/**
 * ����
 * @author Administrator
 *
 */
@Entity
@Table
public class Thread extends BaseBean {
	@ManyToOne
	@JoinColumn(name="board_id")
	private Board board;//����
	
	private String title;//����
	
	@Basic(fetch=FetchType.LAZY)//�ӳټ���
	@Column(columnDefinition="longtext")//����Ϊlongtext����
	private String context;//����
	
	@ManyToOne
	@JoinColumn(name="author_id")//���
	private Person author;//����
	
	private String ipCreated;//����ʱ��IP��ַ
	private int hit;//����������ʣ�
	
	@ManyToOne
	@JoinColumn(name="author_last_replied_id")//���
	private Person authorLastReplied;//���ظ���
	
	@Temporal(TemporalType.TIMESTAMP)//ʱ�������
	private Date dataLastReplied;//���ظ�ʱ��
	
	private boolean readonly;//�Ƿ�ֻ��
	private boolean topped;//�Ƿ��ö�
	private int replyCount;//������
	
	
	
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
