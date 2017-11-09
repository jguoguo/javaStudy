package com.bjpowernode.drp.service;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bjpowernode.drp.AppException;
import com.bjpowernode.drp.BeanFactory;

import com.bjpowernode.drp.HibernateUtils;
import com.bjpowernode.drp.PageModel;
import com.bjpowernode.drp.dao.ItemDao;
import com.bjpowernode.drp.domain.Item;
import com.bjpowernode.drp.web.HibernateFilter;

/**
 * ���õ���ģʽʵ��
 * @author Administrator
 *
 */
public class ItemServiceImpl implements ItemService {

	@Override
	public void addItem(Item item) {
		Session session=null;
		Transaction tx=null;
		try{
			//session=HibernateUtils.getSession();
			session=HibernateFilter.getSession();
			tx=session.beginTransaction();
			
			getItemDao().addItem(session, item);
			session.flush();
			//�ύ����
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
			throw new AppException("�������ʧ�ܣ�");
		}
//		finally{
//			HibernateUtils.closeSession(session);
//		}
	}

	/**
	 * ��ҳ��ѯ
	 */
	public PageModel findAllItem(String queryString, int pageNo, int pageSize) {
		Session session=null;
		Transaction tx=null;
		PageModel pageModel;
		try{
			//session=HibernateUtils.getSession();
			session=HibernateFilter.getSession();
			tx=session.beginTransaction();
			
			pageModel=getItemDao().findAllItem(session, queryString, pageNo, pageSize);
			session.flush();
			//�ύ����
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
			throw new AppException("��ҳ��ѯ����ʧ�ܣ�");
		}
//		finally{
//			HibernateUtils.closeSession(session);
//		}
		
		
		return pageModel;
	}

	/**
	 * �޸�����
	 */
	public void modifyItem(Item item) {
		
		Session session=null;
		Transaction tx=null;
		try{
			//session=HibernateUtils.getSession();
			session=HibernateFilter.getSession();
			tx=session.beginTransaction();
			
			getItemDao().modifyItem(session, item);
			session.flush();
			//�ύ����
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
			throw new AppException("�޸�����ʧ�ܣ�");
		}
//		finally{
//			HibernateUtils.closeSession(session);
//		}
	}

	/**
	 * ɾ������
	 */
	public void delItem(String[] itemNos) {
		Session session=null;
		Transaction tx=null;
		try{
			//session=HibernateUtils.getSession();
			session=HibernateFilter.getSession();
			tx=session.beginTransaction();
			
			getItemDao().delItem(session, itemNos);
			session.flush();
			//�ύ����
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
			throw new AppException("ɾ������ʧ�ܣ�");
		}
//		finally{
//			HibernateUtils.closeSession(session);
//		}
	}

	/**
	 * �������ϴ����ѯ
	 */
	public Item findItemById(String itemNo) {
		Session session=null;
		Transaction tx=null;
		Item item=null;
		try{
			//session=HibernateUtils.getSession();
			session=HibernateFilter.getSession();
			tx=session.beginTransaction();
			
			item=getItemDao().findItemById(session, itemNo);
			session.flush();
			//�ύ����
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
			throw new AppException("��ѯ����ʧ�ܣ�");
		}
//		finally{
//			HibernateUtils.closeSession(session);
//		}
		
		return item;
	}

	/**
	 * �����ϴ��ļ�
	 */
	public void modifyUploadFileNameField(String itemNo, String uploadFileName) {
		Session session=null;
		Transaction tx=null;
		try{
			//session=HibernateUtils.getSession();
			session=HibernateFilter.getSession();
			tx=session.beginTransaction();
			
			getItemDao().modifyUploadFileNameField(session, itemNo, uploadFileName);
			session.flush();
			//�ύ����
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
			throw new AppException("�ϴ�����ͼƬʧ�ܣ�");
		}
//		finally{
//			HibernateUtils.closeSession(session);
//		}
	}
	
	private ItemDao getItemDao(){
		ItemDao itemDao=(ItemDao)BeanFactory.getInstance().getBean(ItemDao.class);
		return itemDao;
	}
}
