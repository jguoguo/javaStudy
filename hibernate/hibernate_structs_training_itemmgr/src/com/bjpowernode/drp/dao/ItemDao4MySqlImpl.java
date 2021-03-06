package com.bjpowernode.drp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.bjpowernode.drp.DBUtil;
import com.bjpowernode.drp.PageModel;
import com.bjpowernode.drp.domain.Item;
import com.bjpowernode.drp.domain.ItemCategory;
import com.bjpowernode.drp.domain.ItemUnit;

public class ItemDao4MySqlImpl implements ItemDao{

	
	public void addItem(Session session, Item item) {
		// TODO Auto-generated method stub
		session.save(item);
	}

	
	public Item findItemById(Session session, String itemNO) {
		
		return (Item)session.load(Item.class, itemNO);
	}

	
	public PageModel findAllItem(Session session, String queryString,
			int pageNo, int pageSize) {
		Query query=null;
		if(queryString!=null && !"".equals(queryString)){
			query=session.createQuery("from Item i where i.itemNo like ? i.itemName like ? order by i.itemNo")
					.setParameter(0, queryString+"%")
					.setParameter(1, queryString+"%");
		}else{
			query=session.createQuery("from Item i order by i.itemNo");
		}
		List itemList=query.setFirstResult((pageNo-1)*pageSize)
							.setMaxResults(pageSize)
							.list();
		PageModel pageModel=new PageModel();
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		pageModel.setList(itemList);
		pageModel.setTotalRecords(getTotalRecords(session,queryString));
		
		return pageModel;
	}
	
	/**
	 * 根据条件取得记录数
	 * @param conn
	 * @param queryStr
	 * @return
	 */
	private int getTotalRecords(Session session, String queryString) {
		Query query=null;
		if(queryString!=null && !"".equals(queryString)){
			query=session.createQuery("select count(*) from Item i where i.itemNo like ? i.itemName like ?")
					.setParameter(0, queryString+"%")
					.setParameter(1, queryString+"%");
		}else{
			query=session.createQuery("select count(*) from Item i");
		}
		return ((Long)query.uniqueResult()).intValue();
	}

	
	public void modifyItem(Session session, Item item) {	
		session.update(item);
	}

	
	public void delItem(Session session, String[] itemNos) {
		for(int i=0;i<itemNos.length;i++){
			session.delete(
			session.load(Item.class, itemNos[i]));
		}
	}

	
	public void modifyUploadFileNameField(Session session, String itemNo,String uploadFileName) {
		Item item=(Item)session.load(Item.class, itemNo);
		item.setUploadFileName(uploadFileName);
	}

}
