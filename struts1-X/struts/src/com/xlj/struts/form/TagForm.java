package com.xlj.struts.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class TagForm extends ActionForm {
	private String checkbox;	//��Ӧ����checkbox��ѡ����
	private FormFile file;		//��Ӧ����file�ļ���
	private String hidden;		//��Ӧ����hidden������
	private String[] multibox;	//��Ӧ���Ķ��ͬ����checkbox��ѡ��
	private String password;	//��Ӧ����password
	private String radio;		//��Ӧ����radio��ѡ��
	private String select;		//��Ӧ����select
	private String text;		//��Ӧ����text�������
	private String textarea;	//��Ӧ����textarea�ı�����
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
