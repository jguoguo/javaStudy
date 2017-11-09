package com.xlj.forum.struts.form;

import com.xlj.forum.bean.Board;
import com.xlj.forum.bean.Category;

public class BoardForm extends ForumForm {
	private Category catetory=new Category();//Category实体类对象
	private Board board=new Board();//Board实体类对象
	private int[] adminId;//版主ID
	public Category getCatetory() {
		return catetory;
	}
	public void setCatetory(Category catetory) {
		this.catetory = catetory;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public int[] getAdminId() {
		return adminId;
	}
	public void setAdminId(int[] adminId) {
		this.adminId = adminId;
	}
	
	
}
