package com.xlj.forum.struts.form;

import org.apache.struts.action.ActionForm;

public class ForumForm extends ActionForm{//FormBean基类
	private String action;//action参数
	private String title;//页面标题，JSP显示该属性
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
