package com.xlj.forum.struts.form;

import com.xlj.forum.bean.Board;
import com.xlj.forum.bean.Category;

public class BoardForm extends ForumForm {
	private Category catetory=new Category();//Categoryʵ�������
	private Board board=new Board();//Boardʵ�������
	private int[] adminId;//����ID
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
