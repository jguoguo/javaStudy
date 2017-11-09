package com.bjpowernode.drp.util;

import java.util.List;

/**
 * 封装分页信息
 * @author Administrator
 *
 */
public class PageModel {
	//结果集
	private List list;
	
	//总记录数
	private int totalRecords;
	
	//每页多少条数据
	private int pageSize;
	
	//当前第几页
	private int pageNo;
	
	//获取总页数
	public int getTotalPages(){
		return (totalRecords+pageSize-1)/pageSize;
	}
	//获得首页的页号
	public int getTopPageNo(){
		return 1;
	}
	//上一页
	public int getPreviousPageNo(){
		if(pageNo<=1){
			return 1;
		}else{
			return pageNo-1;
		}
		
	}
	//下一页
	public int getNextPageNo(){
		if(pageNo>=getBottomPageNo()){
			return getBottomPageNo();
		}else{
			return pageNo+1;
		}
		
	}
	//获得尾页页号
	public int getBottomPageNo(){
		return getTotalPages();
	}
	
	
	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	
}
