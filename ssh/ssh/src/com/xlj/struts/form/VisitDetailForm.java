package com.xlj.struts.form;

import org.apache.struts.action.ActionForm;

import com.xlj.struts.bean.VisitDetail;

public class VisitDetailForm extends ActionForm {
	private VisitDetail v=new VisitDetail();//接收JavaScript提交的信息
	private String err;//接收JavaScript异常消息
	private String sort;//排序列
	private String order;//排序方式
	public VisitDetail getV() {
		return v;
	}
	public void setV(VisitDetail v) {
		this.v = v;
	}
	public String getErr() {
		return err;
	}
	public void setErr(String err) {
		this.err = err;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
}
