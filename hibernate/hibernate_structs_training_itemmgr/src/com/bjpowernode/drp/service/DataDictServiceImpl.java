package com.bjpowernode.drp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bjpowernode.drp.AppException;
import com.bjpowernode.drp.DBUtil;
import com.bjpowernode.drp.HibernateUtils;
import com.bjpowernode.drp.domain.Item;
import com.bjpowernode.drp.domain.ItemCategory;
import com.bjpowernode.drp.domain.ItemUnit;

public class DataDictServiceImpl implements DataDictService {
	/**
	 * 取得物料类别代码列表
	 */
	@Override
	public List<ItemCategory> getItemCategoryList() {
		Session session=null;
		Transaction tx=null;
		List list=new ArrayList();
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			list=session.createQuery("from ItemCategory").list();
			//提交事物
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
			throw new AppException("查询物料类别失败！");
		}finally{
			HibernateUtils.closeSession(session);
		}
		return list;
	}

	@Override
	public List<ItemUnit> getItemUnitList() {
		Session session=null;
		Transaction tx=null;
		List list=new ArrayList();
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			list=session.createQuery("from ItemUnit").list();
			//提交事物
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
			throw new AppException("查询物料单位失败！");
		}finally{
			HibernateUtils.closeSession(session);
		}
		return list;
	}

}
