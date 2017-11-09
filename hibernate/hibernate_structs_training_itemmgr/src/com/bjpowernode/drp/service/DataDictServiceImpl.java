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
	 * ȡ�������������б�
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
			//�ύ����
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
			throw new AppException("��ѯ�������ʧ�ܣ�");
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
			//�ύ����
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
			throw new AppException("��ѯ���ϵ�λʧ�ܣ�");
		}finally{
			HibernateUtils.closeSession(session);
		}
		return list;
	}

}
