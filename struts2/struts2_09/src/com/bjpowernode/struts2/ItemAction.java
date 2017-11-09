package com.bjpowernode.struts2;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;

public class ItemAction {
	private String itemCode;
	private String itemName;
	private String spec;
	private List<String> list;
	
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public String execute() throws Exception{
		ItemManager itemmgr=new ItemManager();
		itemmgr.add(itemCode, itemName,spec);
		
		list=new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		return Action.SUCCESS;
	}
}
