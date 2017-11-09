package com.bjpowernode.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import junit.framework.TestCase;

public class CompositeRKMappingTest extends TestCase {
	public void testSave1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			FiscalYearPeriod fiscalYearPeriod=new FiscalYearPeriod();
			//构造复合主键对象
			FiscalYearPeriodPK fiscalYearPeriodPK=new FiscalYearPeriodPK();
			fiscalYearPeriodPK.setFiscalYear(2009);
			fiscalYearPeriodPK.setFiscalPeriod(12);
			
			fiscalYearPeriod.setFisCalYearPeriodPK(fiscalYearPeriodPK);
			fiscalYearPeriod.setBeginDate(new Date());
			fiscalYearPeriod.setEndDate(new Date());
			fiscalYearPeriod.setPeriodSts("Y");
			
			session.save(fiscalYearPeriod);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached状态
	}
	
	public void testLoad1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			//构造复合主键对象
			FiscalYearPeriodPK fiscalYearPeriodPK=new FiscalYearPeriodPK();
			fiscalYearPeriodPK.setFiscalYear(2009);
			fiscalYearPeriodPK.setFiscalPeriod(12);
			
		
			FiscalYearPeriod fiscalYearPeriod=(FiscalYearPeriod)session.load(FiscalYearPeriod.class, fiscalYearPeriodPK);
			System.out.print(fiscalYearPeriod.getPeriodSts());
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached状态
	}
}
