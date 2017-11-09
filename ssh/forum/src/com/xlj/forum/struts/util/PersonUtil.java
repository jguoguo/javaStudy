package com.xlj.forum.struts.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xlj.forum.bean.Person;

/**
 * �洢session����
 * @author Administrator
 *
 */
public class PersonUtil {
	public static final String PERSON_INFO="personInfo";//session��ֵ
	/**
	 * ��ȡPersonInfo 
	 * @param request
	 * @param response
	 * @return
	 */
	public static PersonInfo getPersonInfo(HttpServletRequest request, HttpServletResponse response){
		return (PersonInfo)request.getSession(true).getAttribute(PERSON_INFO);
	}
	
	/**
	 * ����PersonInfo
	 * @param request
	 * @param response
	 * @param personInfo
	 */
	public static void setPersonInfo(HttpServletRequest request, HttpServletResponse response,PersonInfo personInfo){
		request.getSession(true).setAttribute(PERSON_INFO, personInfo);
	}
	
	
	
	/**
	 * ����PersonInfo
	 * @param request
	 * @param response
	 * @param personInfo
	 */
	public static void setPersonInfo(HttpServletRequest request, HttpServletResponse response,Person person){
		PersonInfo personInfo=new PersonInfo();//����PersonInfo
		personInfo.setId(person.getId());
		personInfo.setAccount(person.getAccount());
		setPersonInfo(request,response,personInfo);
	}
}
