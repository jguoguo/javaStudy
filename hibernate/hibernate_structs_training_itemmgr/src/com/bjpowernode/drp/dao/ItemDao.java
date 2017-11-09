package com.bjpowernode.drp.dao;



import org.hibernate.Session;

import com.bjpowernode.drp.PageModel;
import com.bjpowernode.drp.domain.Item;

public interface ItemDao {
	/**
	 * �������
	 * @param session
	 * @param item
	 */
	public void addItem(Session session,Item item);
	/**
	 * ����id��ѯ
	 * @param session
	 * @param itemNO
	 * @return
	 */
	public Item findItemById(Session session,String itemNO);
	/**
	 * ��ҳ��ѯ
	 * @param session
	 * @param queryString
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageModel findAllItem(Session session,String queryString, int pageNo, int pageSize);
	/**
	 * �޸�����
	 * @param session
	 * @param item
	 */
	public void modifyItem(Session session,Item item);
	
	/**
	 * ɾ������
	 * @param session
	 * @param itemNos
	 */
	public void delItem(Session session,String[] itemNos);
	
	/**
	 * �����ϴ�ͼƬ
	 * @param session
	 * @param itemNo
	 * @param uploadFileName
	 */
	public void modifyUploadFileNameField(Session session,String itemNo, String uploadFileName);
}
