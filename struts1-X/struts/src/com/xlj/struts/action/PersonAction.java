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
		if("add".equals(personForm.getAction())){//如果为add动作
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
					.parse(personForm.getBirthday()).getTime());//转化日期
		Person person=new Person();//转化为普通的POJO
		person.setAccount(personForm.getAccount());//设置String类型
		person.setName(personForm.getName());//设置String类型
		person.setSecret(personForm.getSecret());//设置boolean类型
		person.setCreateDate(new Timestamp(System.currentTimeMillis()));//设置时间戳
		person.setBirthday(birthday);//设置Date类型
		person.setHobby(Arrays.asList(personForm.getHobby()));//设置List类型
		PersonDao personDao=new PersonDao();
		Connection conn=getDataSource(request).getConnection();//struts的action提供getDataSource(request)获取数据源
		personDao.addPerson(conn,person);
		request.setAttribute("person", person);//放进request,供jsp用
		return mapping.findForward("success");
	}
	
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		PersonDao personDao=new PersonDao();
		Connection conn=getDataSource(request).getConnection();
		List<Person> personList=personDao.listPersons(conn);//列出所有的Person
		request.setAttribute("personList", personList);
		return mapping.findForward("list");
	}

}
