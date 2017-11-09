package com.xlj.listener.singleton;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.sun.org.apache.commons.logging.Log;
import com.sun.org.apache.commons.logging.LogFactory;

public class LoginSessionListener implements HttpSessionAttributeListener {

	Log log=LogFactory.getLog(this.getClass());//��־��¼��
	Map<String,HttpSession> map=new HashMap<String,HttpSession>();//����session
	public void attributeAdded(HttpSessionBindingEvent event) {

		//���session����ʱ������
		String name=event.getName();//�½����Ե�����
		if(name.equals("personInfo")){//��¼
			PersonInfo personInfo=(PersonInfo)event.getValue();
			//�´�����PersonInfo
			if(map.get(personInfo.getAccount())!=null){
				//Map���м�¼���������˻������������ϵ�¼��������ǰ�ĵ�¼ʧЧ
				HttpSession session=map.get(personInfo.getAccount());
				//�˺�����Session
				PersonInfo oldPersonInfo=(PersonInfo)session.getAttribute("personInfo");
				log.info("�˺�"+oldPersonInfo.getAccount()+"��"+oldPersonInfo.getIp()+"�Ѿ���¼���õ�¼���������ߡ�");
				session.removeAttribute("personInfo");//�Ƴ��˺�
				session.setAttribute("msg", "�����˺��Ѿ������������ϵ�¼�����������ߡ�");
			}
			//��Session���û���Ϊ����������map��
			map.put(personInfo.getAccount(), event.getSession());
			log.info("�˻�"+personInfo.getAccount()+"��"+personInfo.getIp()+"��¼");
		}
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {

		//ɾ������ǰ������
		String name=event.getName();//��ɾ��������
		if(name.equals("personInfo")){
			PersonInfo personInfo=(PersonInfo)event.getValue();
			//���Ƴ���PersonInfo
			map.remove(personInfo.getAccount());//��map���Ƴ�
			log.info("�˺�"+personInfo.getAccount()+"ע����");
		}
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {
		//�޸�����ʱ������
		String name=event.getName();//���޸ĵ�������
		if(name.equals("personInfo")){//û��ע��������£�����һ���˻���½
			PersonInfo oldPersonInfo=(PersonInfo)event.getValue();//�Ƴ��ɵĵ�½��Ϣ
			map.remove(oldPersonInfo.getAccount());//ɾ��map�еľɼ�¼
			//�µĵ�¼��Ϣ
			PersonInfo personInfo=(PersonInfo)event.getSession().getAttribute("personInfo");
			//ҲҪ����µ�¼���˻��Ƿ��ڱ�Ļ����ϵ�¼��
			if(map.get(personInfo.getAccount())!=null){
				//map���м�¼���������˺������������ϵ�¼��������ǰ�ĵ�¼ʧЧ
				HttpSession session=map.get(personInfo.getAccount());
				session.setAttribute("msg","�����˻��Ѿ������������ϵ�¼,����������");
			}
			map.put(personInfo.getAccount(), event.getSession());
		}
			
	}

}
