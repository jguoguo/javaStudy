package com.bjpowernode.hibernate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import junit.framework.TestCase;

public class CollectionMappingTest extends TestCase {
	public void testSave1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			CollectionMapping c=new CollectionMapping();
			c.setName("ÕÅÈý");
			
			//ÉèÖÃSet
			Set setValues=new HashSet();
			setValues.add("a");
			setValues.add("b");
			c.setSetValues(setValues);
			
			List listValues=new ArrayList();
			listValues.add("c");
			listValues.add("d");
			c.setListValues(listValues);
			
			String[] arrayValues=new String[]{"e","f"};
			c.setArrayValues(arrayValues);
			
			Map mapValues=new HashMap();
			mapValues.put("k1", "v1");
			mapValues.put("k2", "v2");
			c.setMapValues(mapValues);
			
			session.save(c);
			
			
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached×´Ì¬
	}

	
	public void testLoad1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			CollectionMapping c=(CollectionMapping)session.get(CollectionMapping.class, 1);
			System.out.println("name="+c.getName());
			System.out.println("setValue="+c.getSetValues());
			System.out.println("listVaule="+c.getListValues());
			System.out.println("mapValue="+c.getMapValues());
			System.out.println("arrayValue="+c.getArrayValues());			
			
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached×´Ì¬
	}
}
