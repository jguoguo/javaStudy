package com.bjpowernode.hibernate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class InitData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			for(int i=0;i<10;i++){
				Classes classes=new Classes();
				classes.setName("班级"+i);
				session.save(classes);
				for(int j=0;j<10;j++){
					Student student=new Student();
					student.setName("班级"+i+"的学生"+j);
					student.setCreateDate(randomDate("2009-07-01","2009-09-01"));
					student.setClasses(classes);
					session.save(student);
				}
				
			}
			for(int i=0;i<5;i++){
				Classes classes=new Classes();
				classes.setName("无学生班级"+i);
				session.save(classes);
			}
			
			for(int i=0;i<10;i++){
				Student student=new Student();
				student.setName("无业游民"+i);
				session.save(student);
			}
			
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}

	}
	
	/**
	 * 获取随机日期
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	private static Date randomDate(String beginDate,String endDate){
		try{
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			Date start=format.parse(beginDate);
			Date end=format.parse(endDate);
			if(start.getTime() >= end.getTime()){
				return null;
			}
			long date=random(start.getTime(),end.getTime());
			return new Date(date);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	private static long random(long begin,long end){
		long rtn=begin+(long)(Math.random()*(end-begin));
		if(rtn==begin || rtn==end){
			return random(begin,end);
		}
		return rtn;
	}
}
