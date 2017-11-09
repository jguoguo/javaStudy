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
	
	
	private IPersonService<Person> personService;//service,ͨ��setter����ע��

	public IPersonService<Person> getPersonService() {
		return personService;
	}


	public void setPersonService(IPersonService<Person> personService) {
		this.personService = personService;
	}


	/**
	 * ��ʾע��ҳ��
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
		personForm.setTitle("�û�ע��");//���ñ���
		return mapping.findForward("add");
	}
	
	
	/**
	 * ע�᷽��
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
		personForm.setTitle("�û�ע��");//���ñ���
		
		Person person=personForm.getPerson();
		person.setIpCreated(request.getRemoteAddr());//��¼ע��IP
		person.setIpLastActived(request.getRemoteAddr());//��¼���ε�¼IP
		person.setDateCreated(new Date());//��¼ע��ʱ��
		person.setDateLastActived(new Date());//��¼���ε�¼ʱ��
		
		if(person.getAccount()==null || person.getAccount().trim().length()==0){
			request.setAttribute("message", "�������˺�");
			return this.initadd(mapping, form, request, response);//ת������ҳ��
		}
		
		if(person.getPassword()==null || person.getPassword().trim().length()==0
				|| !person.getPassword().equals(personForm.getPassword())){
			request.setAttribute("message", "���벻һ��");
			return this.initadd(mapping, form, request, response);//ת������ҳ��
		}
		try{
			personService.create(person);//���浽���ݿ�
			PersonUtil.setPersonInfo(request, response, person);//����Ϣд��session
			
			request.setAttribute("message", "ע��ɹ�");
			return new ActionForward("success","form/person/success.jsp",false);
		}catch(Exception e){
			request.setAttribute("message", "ע��ʧ�ܣ�ԭ��"+e.getMessage());
			return this.initadd(mapping, form, request, response);//ת������ҳ��
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
	 * ��¼
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {//��¼
		PersonForm personForm=(PersonForm)form;
		personForm.setTitle("�û���¼");//���ñ���
		
		Person person=personService.getPerson(personForm.getPerson().getAccount(), personForm.getPerson().getPassword());//���Ҽ�¼
		
		if(person==null){
			throw new AccountException("�û����������");
		}
		
		PersonUtil.setPersonInfo(request, response, person);//д��session
		person.setIpLastActived(request.getRemoteAddr());//��¼��¼IP
		person.setDateLastActived(new Date());//��¼��¼ʱ��
		
		personService.save(person);
		request.setAttribute("message", "��ӭ����");
		return new ActionForward("success","/form/success.jsp",false);
		
	}
	
	/**
	 * ע��
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {//ע��
		PersonForm personForm=(PersonForm)form;
		personForm.setTitle("�û�ע��");
		
		request.getSession(true).setAttribute(PersonUtil.PERSON_INFO, null);
		return new ActionForward("success","/",true);

	}
	
	/**
	 * ��ѯ�û���Ϣ
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
		personForm.setTitle("�鿴�û�����");
		Person person=personService.find(Person.class, personForm.getPerson().getId());
		
		request.setAttribute("person", person);
		return new ActionForward("view","/form/viewPerson.jsp",false);
	}

}
