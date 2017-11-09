package com.xlj.struts.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class TagForm extends ActionForm {
	private String checkbox;	//对应表单的checkbox复选框域
	private FormFile file;		//对应表单的file文件域
	private String hidden;		//对应表单的hidden隐藏域
	private String[] multibox;	//对应表单的多个同名的checkbox复选框
	private String password;	//对应表单的password
	private String radio;		//对应表单的radio单选框
	private String select;		//对应表单的select
	private String text;		//对应表单的text输入框域
	private String textarea;	//对应表单的textarea文本区域
	public String getCheckbox() {
		return checkbox;
	}
	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}
	public FormFile getFile() {
		return file;
	}
	public void setFile(FormFile file) {
		this.file = file;
	}
	public String getHidden() {
		return hidden;
	}
	public void setHidden(String hidden) {
		this.hidden = hidden;
	}
	public String[] getMultibox() {
		return multibox;
	}
	public void setMultibox(String[] multibox) {
		this.multibox = multibox;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRadio() {
		return radio;
	}
	public void setRadio(String radio) {
		this.radio = radio;
	}
	public String getSelect() {
		return select;
	}
	public void setSelect(String select) {
		this.select = select;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTextarea() {
		return textarea;
	}
	public void setTextarea(String textarea) {
		this.textarea = textarea;
	}
	
	
}
