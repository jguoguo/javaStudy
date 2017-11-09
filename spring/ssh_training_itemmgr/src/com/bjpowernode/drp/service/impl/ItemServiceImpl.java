package com.bjpowernode.drp.service.impl;



import com.bjpowernode.drp.AppException;


import com.bjpowernode.drp.PageModel;
import com.bjpowernode.drp.dao.ItemDao;
import com.bjpowernode.drp.domain.Item;
import com.bjpowernode.drp.service.ItemService;

/**
 * ���õ���ģʽʵ��
 * @author Administrator
 *
 */
public class ItemServiceImpl implements ItemService {

	private ItemDao itemDao;
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	@Override
	public void addItem(Item item) {
		try{
			itemDao.addItem(item);
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("�������ʧ�ܣ�");
		}
	}

	/**
	 * ��ҳ��ѯ
	 */
	public PageModel findAllItem(String queryString, int pageNo, int pageSize) {
		try{
			return itemDao.findAllItem(queryString, pageNo, pageSize);
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("��ҳ��ѯʧ�ܣ�");
		}
	}

	/**
	 * �޸�����
	 */
	public void modifyItem(Item item) {
		try{
			itemDao.modifyItem(item);
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("�޸�����ʧ�ܣ�");
		}
	}

	/**
	 * ɾ������
	 */
	public void delItem(String[] itemNos) {
		try{
			itemDao.delItem(itemNos);
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("ɾ������ʧ�ܣ�");
		}
	}

	/**
	 * �������ϴ����ѯ
	 */
	public Item findItemById(String itemNo) {
		try{
			return itemDao.findItemById(itemNo);
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("�������ϴ����ѯ����ʧ�ܣ�");
		}
	}

	/**
	 * �����ϴ��ļ�
	 */
	public void modifyUploadFileNameField(String itemNo, String uploadFileName) {

		try{
			itemDao.modifyUploadFileNameField(itemNo,uploadFileName);
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("ɾ������ʧ�ܣ�");
		}
	}
	
}
