package com.xlj.forum.struts.action;

import java.util.Date;

import javax.security.auth.login.AccountException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.xlj.forum.bean.Person;
import com.xlj.forum.service.IPersonService;
import com.xlj.forum.struts.form.PersonForm;
import com.xlj.forum.struts.util.PersonUtil;

public class PersonAction extends ForumAction {
	
	
	private IPersonService<Person> personService;//service,通过setter方法注入

	public IPersonService<Person> getPersonService() {
		return personService;
	}


	public void setPersonService(IPersonService<Person> personService) {
		this.personService = personService;
	}


	/**
	 * 显示注册页面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward initadd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PersonForm personForm=(PersonForm)form;
		personForm.setTitle("用户注册");//设置标题
		return mapping.findForward("add");
	}
	
	
	/**
	 * 注册方法
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PersonForm personForm=(PersonForm)form;
		personForm.setTitle("用户注册");//设置标题
		
		Person person=personForm.getPerson();
		person.setIpCreated(request.getRemoteAddr());//记录注册IP
		person.setIpLastActived(request.getRemoteAddr());//记录本次登录IP
		person.setDateCreated(new Date());//记录注册时间
		person.setDateLastActived(new Date());//记录本次登录时间
		
		if(person.getAccount()==null || person.getAccount().trim().length()==0){
			request.setAttribute("message", "请输入账号");
			return this.initadd(mapping, form, request, response);//转到输入页面
		}
		
		if(person.getPassword()==null || person.getPassword().trim().length()==0
				|| !person.getPassword().equals(personForm.getPassword())){
			request.setAttribute("message", "密码不一致");
			return this.initadd(mapping, form, request, response);//转到输入页面
		}
		try{
			personService.create(person);//保存到数据库
			PersonUtil.setPersonInfo(request, response, person);//将信息写入session
			
			request.setAttribute("message", "注册成功");
			return new ActionForward("success","form/person/success.jsp",false);
		}catch(Exception e){
			request.setAttribute("message", "注册失败，原因："+e.getMessage());
			return this.initadd(mapping, form, request, response);//转到输入页面
		}
	}
	@Override
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 登录
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {//登录
		PersonForm personForm=(PersonForm)form;
		personForm.setTitle("用户登录");//设置标题
		
		Person person=personService.getPerson(personForm.getPerson().getAccount(), personForm.getPerson().getPassword());//查找记录
		
		if(person==null){
			throw new AccountException("用户名密码错误");
		}
		
		PersonUtil.setPersonInfo(request, response, person);//写入session
		person.setIpLastActived(request.getRemoteAddr());//记录登录IP
		person.setDateLastActived(new Date());//记录登录时间
		
		personService.save(person);
		request.setAttribute("message", "欢迎回来");
		return new ActionForward("success","/form/success.jsp",false);
		
	}
	
	/**
	 * 注销
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {//注销
		PersonForm personForm=(PersonForm)form;
		personForm.setTitle("用户注销");
		
		request.getSession(true).setAttribute(PersonUtil.PERSON_INFO, null);
		return new ActionForward("success","/",true);

	}
	
	/**
	 * 查询用户信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PersonForm personForm=(PersonForm)form;
		personForm.setTitle("查看用户资料");
		Person person=personService.find(Person.class, personForm.getPerson().getId());
		
		request.setAttribute("person", person);
		return new ActionForward("view","/form/viewPerson.jsp",false);
	}

}
