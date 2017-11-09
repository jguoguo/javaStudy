package com.xlj.struts.util;

import javax.servlet.http.HttpServletRequest;

public class Pagination {
	//每页多少条记录
	private int pageSize=10;
	//当前第几页
	private int pageNo=1;
	private int upPage;
	private int nextPage;
	private int recordCount;
	private int totalPage;
	private HttpServletRequest request;

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

	public int getUpPage() {
		return upPage;
	}

	/**
	 * 设置上一页
	 * @param upPage
	 */
	public void setUpPage(int upPage) {
		this.upPage = (this.pageNo>1)?this.pageNo-1:this.pageNo;
	}

	public int getNextPage() {
		return nextPage;
	}
	/**
	 * 设置下一页
	 * @param nextPage
	 */
	public void setNextPage(int nextPage) {
		this.nextPage = (this.pageNo==this.recordCount)?this.pageNo:this.pageNo+1;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * 获取第一条记录位置
	 * @return
	 */
	public int getFirstResult(){
		return (this.getPageNo()-1)*this.getPageSize();
	} 
	/**
	 * 获取最后一条记录位置
	 * @return
	 */
	public int getLastResult(){
		return this.getPageNo()*this.getPageSize();
	}
}
