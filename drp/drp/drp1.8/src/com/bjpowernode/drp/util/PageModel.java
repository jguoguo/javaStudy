package com.bjpowernode.drp.util;

import java.util.List;

/**
 * ��װ��ҳ��Ϣ
 * @author Administrator
 *
 */
public class PageModel {
	//�����
	private List list;
	
	//�ܼ�¼��
	private int totalRecords;
	
	//ÿҳ����������
	private int pageSize;
	
	//��ǰ�ڼ�ҳ
	private int pageNo;
	
	//��ȡ��ҳ��
	public int getTotalPages(){
		return (totalRecords+pageSize-1)/pageSize;
	}
	//�����ҳ��ҳ��
	public int getTopPageNo(){
		return 1;
	}
	//��һҳ
	public int getPreviousPageNo(){
		if(pageNo<=1){
			return 1;
		}else{
			return pageNo-1;
		}
		
	}
	//��һҳ
	public int getNextPageNo(){
		if(pageNo>=getBottomPageNo()){
			return getBottomPageNo();
		}else{
			return pageNo+1;
		}
		
	}
	//���βҳҳ��
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
