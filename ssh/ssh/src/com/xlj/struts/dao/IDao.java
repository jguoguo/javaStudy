package com.xlj.struts.dao;

import java.util.List;

import com.xlj.struts.bean.VisitOnline;

public interface IDao {
	public static final int TIME_OUT=60*1000*20;//超时时间:20分钟
	public void create(Object obj);//创建实体对象
	public void save(Object obj);//保存实体对象
	public int getTotalCount(String hql);//获取数据记录数
	public List list(String hql,int firstResult,int maxResults);//获取分页内的数据
	public VisitOnline findValidOnline(String ip,String userid);//获取userid的用户在线信息
	public int removeTimeOutOnlineRecords();//将超时的在线用户置为离线
}
