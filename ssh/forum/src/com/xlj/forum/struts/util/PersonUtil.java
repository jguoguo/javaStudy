package com.xlj.forum.struts.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xlj.forum.bean.Person;

/**
 * 存储session代码
 * @author Administrator
 *
 */
public class PersonUtil {
	public static final String PERSON_INFO="personInfo";//session键值
	/**
	 * 获取PersonInfo 
	 * @param request
	 * @param response
	 * @return
	 */
	public static PersonInfo getPersonInfo(HttpServletRequest request, HttpServletResponse response){
		return (PersonInfo)request.getSession(true).getAttribute(PERSON_INFO);
	}
	
	/**
	 * 设置PersonInfo
	 * @param request
	 * @param response
	 * @param personInfo
	 */
	public static void setPersonInfo(HttpServletRequest request, HttpServletResponse response,PersonInfo personInfo){
		request.getSession(true).setAttribute(PERSON_INFO, personInfo);
	}
	
	
	
	/**
	 * 设置PersonInfo
	 * @param request
	 * @param response
	 * @param personInfo
	 */
	public static void setPersonInfo(HttpServletRequest request, HttpServletResponse response,Person person){
		PersonInfo personInfo=new PersonInfo();//创建PersonInfo
		personInfo.setId(person.getId());
		personInfo.setAccount(person.getAccount());
		setPersonInfo(request,response,personInfo);
	}
}
