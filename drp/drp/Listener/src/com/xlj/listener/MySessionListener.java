package com.xlj.listener;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.xlj.util.ApplicationConstants;

/**
 * ����Session����ά�������û��б��ܷ���������
 * @author Administrator
 *
 */
public class MySessionListener implements HttpSessionListener,HttpSessionAttributeListener{

	public void sessionCreated(HttpSessionEvent sessionEvent) {
		//session����ʱ������
		HttpSession session=sessionEvent.getSession();//�´�����session
		ApplicationConstants.SESSION_MAP.put(session.getId(), session);//����session
		ApplicationConstants.TOTAL_HISTORY_COUNT++;//�ܷ�������++
		
		//�����ǰ��������������ʷ��¼
		if(ApplicationConstants.SESSION_MAP.size()>ApplicationConstants.MAX_ONLINE_COUNT){
			ApplicationConstants.MAX_ONLINE_COUNT=ApplicationConstants.SESSION_MAP.size();//�������������
			ApplicationConstants.MAX_ONLINE_COUNT_DATE=new Date();//����ʱ��
		}
	}

	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		//session����ʱ������
		HttpSession session=sessionEvent.getSession();//���������ٵ�Session
		
		ApplicationConstants.SESSION_MAP.remove(session.getId());//�Ƴ�session��¼
	}

	public void attributeAdded(HttpSessionBindingEvent event) {
		//�������ʱ������
		if(event.getName().equals("personInfo")){
			//�����personInfo����
			ApplicationConstants.CURRENT_LOGIN_COUNT++;//��ǰ��¼�û���++
			HttpSession session=event.getSession();//��ӵ���session
			//���Ҹ��˺���û�����������ϵ�¼
			for(HttpSession sess:ApplicationConstants.SESSION_MAP.values()){
				//������˺��Ѿ������������ϵ�¼������ǰ�ĵ�¼ʧЧ
				if(event.getValue().equals(sess.getAttribute("personInfo")) && session.getId()!=sess.getId()){
					sess.invalidate();//ʹsessionʧЧ
				}
			}
		}
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {
		//�Ƴ�����ʱ������
		if(event.getName().equals("personInfo")){//ע��
			ApplicationConstants.CURRENT_LOGIN_COUNT--;//��ǰ��¼�û���--
		}
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {
		if(event.getName().equals("personInfo")){//���µ�¼
			HttpSession session=event.getSession();//���µ�¼��session
			for(HttpSession sess:ApplicationConstants.SESSION_MAP.values()){
				//������˺������������ϵ�¼��������ǰ�ĵ�¼ʧЧ
				if(event.getValue().equals(sess.getAttribute("personInfo")) && session.getId()!=sess.getId()){
					sess.invalidate();
				}
			}
		}
	}

}
