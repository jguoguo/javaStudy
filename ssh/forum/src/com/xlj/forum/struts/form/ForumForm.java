package com.xlj.forum.struts.form;

import org.apache.struts.action.ActionForm;

public class ForumForm extends ActionForm{//FormBean����
	private String action;//action����
	private String title;//ҳ����⣬JSP��ʾ������
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
