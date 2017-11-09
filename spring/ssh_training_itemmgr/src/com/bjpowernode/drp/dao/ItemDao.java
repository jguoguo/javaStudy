package com.bjpowernode.drp.dao;



import org.hibernate.Session;

import com.bjpowernode.drp.PageModel;
import com.bjpowernode.drp.domain.Item;

public interface ItemDao {
	/**
	 * �������
	 * 
	 * @param item
	 */
	public void addItem(Item item);
	/**
	 * ����id��ѯ
	 * 
	 * @param itemNO
	 * @return
	 */
	public Item findItemById(String itemNO);
	/**
	 * ��ҳ��ѯ
	 * 
	 * @param queryString
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageModel findAllItem(String queryString, int pageNo, int pageSize);
	/**
	 * �޸�����
	 * 
	 * @param item
	 */
	public void modifyItem(Item item);
	
	/**
	 * ɾ������
	 * 
	 * @param itemNos
	 */
	public void delItem(String[] itemNos);
	
	/**
	 * �����ϴ�ͼƬ
	 * 
	 * @param itemNo
	 * @param uploadFileName
	 */
	public void modifyUploadFileNameField(String itemNo, String uploadFileName);
}
