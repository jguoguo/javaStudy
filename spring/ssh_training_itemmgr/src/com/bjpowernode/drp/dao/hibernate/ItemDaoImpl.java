package com.bjpowernode.drp.dao.hibernate;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bjpowernode.drp.PageModel;
import com.bjpowernode.drp.dao.ItemDao;
import com.bjpowernode.drp.domain.Item;


public class ItemDaoImpl extends HibernateDaoSupport implements ItemDao{

	
	public void addItem( Item item) {
		getHibernateTemplate().save(item);
	}

	
	public Item findItemById(String itemNO) {
		return (Item)getHibernateTemplate().load(Item.class, itemNO);
		
	}

	
	public PageModel findAllItem( final String queryString,
			final int pageNo, final int pageSize) {
		
		
//		Query query=null;
//		if(queryString!=null && !"".equals(queryString)){
//			query=session.createQuery("from Item i where i.itemNo like ? i.itemName like ? order by i.itemNo")
//					.setParameter(0, queryString+"%")
//					.setParameter(1, queryString+"%");
//		}else{
//			query=session.createQuery("from Item i order by i.itemNo");
//		}
//		List itemList=query.setFirstResult((pageNo-1)*pageSize)
//							.setMaxResults(pageSize)
//							.list();
//		PageModel pageModel=new PageModel();
//		pageModel.setPageNo(pageNo);
//		pageModel.setPageSize(pageSize);
//		pageModel.setList(itemList);
//		pageModel.setTotalRecords(getTotalRecords(session,queryString));
		
		
		List itemList=new ArrayList();
		if(queryString !=null && !"".equals(queryString)){
			itemList=getHibernateTemplate().executeFind(new HibernateCallback() {	
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					return session.createQuery("from Item i where i.itemNo like ? i.tiemName like ? order by i.itemNo")
							.setParameter(0, queryString+"%")
							.setParameter(1, queryString+"%")
							.setFirstResult((pageNo-1)*pageSize)
							.setMaxResults(pageSize)
							.list();
				}
			});
		}else{
			itemList=getHibernateTemplate().executeFind(new HibernateCallback() {	
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					return session.createQuery("from Item i order by i.itemNo")
							.setFirstResult((pageNo-1)*pageSize)
							.setMaxResults(pageSize)
							.list();
				}
			});
		}
		
		PageModel pageModel=new PageModel();
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		pageModel.setList(itemList);
		pageModel.setTotalRecords(getTotalRecords(queryString));
		return pageModel;
	}
	
	/**
	 * 根据条件取得记录数
	 * @param conn
	 * @param queryStr
	 * @return
	 */
	private int getTotalRecords( String queryString) {
//		Query query=null;
//		if(queryString!=null && !"".equals(queryString)){
//			query=session.createQuery("select count(*) from Item i where i.itemNo like ? i.itemName like ?")
//					.setParameter(0, queryString+"%")
//					.setParameter(0, queryString+"%");
//		}else{
//			query=session.createQuery("select count(*) from Item i");
//		}
		List list=new ArrayList();
		if(queryString!=null && !"".equals(queryString)){
			list=getHibernateTemplate().find("select count(*) from Item i where i.itemNo like ? i.itemName like ?",
					new Object[]{queryString+"%",queryString+"%"});
		}else{
			list=getHibernateTemplate().find("select count(*) from Item i");
		}
		return ((Long)list.get(0)).intValue();
	}

	
	public void modifyItem( Item item) {	
		getHibernateTemplate().update(item);
	}

	
	public void delItem( String[] itemNos) {
		for(int i=0;i<itemNos.length;i++){
			getHibernateTemplate().delete(
					getHibernateTemplate().load(Item.class, itemNos[i]));
		}
	}

	
	public void modifyUploadFileNameField( String itemNo,String uploadFileName) {
		Item item=(Item)getHibernateTemplate().load(Item.class, itemNo);
		item.setUploadFileName(uploadFileName);
	}

}
