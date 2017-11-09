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
 * 采用单例模式实现
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
			//提交事物
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
			throw new AppException("添加物料失败！");
		}
//		finally{
//			HibernateUtils.closeSession(session);
//		}
	}

	/**
	 * 分页查询
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
			//提交事物
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
			throw new AppException("分页查询物料失败！");
		}
//		finally{
//			HibernateUtils.closeSession(session);
//		}
		
		
		return pageModel;
	}

	/**
	 * 修改物料
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
			//提交事物
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
			throw new AppException("修改物料失败！");
		}
//		finally{
//			HibernateUtils.closeSession(session);
//		}
	}

	/**
	 * 删除物料
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
			//提交事物
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
			throw new AppException("删除物料失败！");
		}
//		finally{
//			HibernateUtils.closeSession(session);
//		}
	}

	/**
	 * 根据物料代码查询
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
			//提交事物
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
			throw new AppException("查询物料失败！");
		}
//		finally{
//			HibernateUtils.closeSession(session);
//		}
		
		return item;
	}

	/**
	 * 保存上传文件
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
			//提交事物
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
			throw new AppException("上传物料图片失败！");
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
