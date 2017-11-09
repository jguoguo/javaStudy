package com.xlj.struts.dao;

import java.util.List;

import com.xlj.struts.bean.VisitOnline;

public interface IDao {
	public static final int TIME_OUT=60*1000*20;//��ʱʱ��:20����
	public void create(Object obj);//����ʵ�����
	public void save(Object obj);//����ʵ�����
	public int getTotalCount(String hql);//��ȡ���ݼ�¼��
	public List list(String hql,int firstResult,int maxResults);//��ȡ��ҳ�ڵ�����
	public VisitOnline findValidOnline(String ip,String userid);//��ȡuserid���û�������Ϣ
	public int removeTimeOutOnlineRecords();//����ʱ�������û���Ϊ����
}
