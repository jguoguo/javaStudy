package com.xlj.struts.action;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.xlj.bean.Person;
import com.xlj.dao.PersonDao;
import com.xlj.struts.form.PersonForm;

public class PersonAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PersonForm personForm=(PersonForm)form;
		if("add".equals(personForm.getAction())){//���Ϊadd����
			return add(mapping,form,request,response);
		}else if("list".equals(personForm.getAction())){
			return list(mapping,form,request,response);
		}
		return mapping.getInputForward();
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		PersonForm personForm=(PersonForm)form;
		Date birthday=new Date(new SimpleDateFormat("yyyy-MM-dd")
					.parse(personForm.getBirthday()).getTime());//ת������
		Person person=new Person();//ת��Ϊ��ͨ��POJO
		person.setAccount(personForm.getAccount());//����String����
		person.setName(personForm.getName());//����String����
		person.setSecret(personForm.getSecret());//����boolean����
		person.setCreateDate(new Timestamp(System.currentTimeMillis()));//����ʱ���
		person.setBirthday(birthday);//����Date����
		person.setHobby(Arrays.asList(personForm.getHobby()));//����List����
		PersonDao personDao=new PersonDao();
		Connection conn=getDataSource(request).getConnection();//struts��action�ṩgetDataSource(request)��ȡ����Դ
		personDao.addPerson(conn,person);
		request.setAttribute("person", person);//�Ž�request,��jsp��
		return mapping.findForward("success");
	}
	
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		PersonDao personDao=new PersonDao();
		Connection conn=getDataSource(request).getConnection();
		List<Person> personList=personDao.listPersons(conn);//�г����е�Person
		request.setAttribute("personList", personList);
		return mapping.findForward("list");
	}

}
