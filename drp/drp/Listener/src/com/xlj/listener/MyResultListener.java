package com.xlj.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * ����request��Ҫ�Ǽ�¼�ͻ���IP��ַ�����ʴ���
 * @author Administrator
 *
 */
public class MyResultListener implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent arg0) {
		//����requestʱ����
		
	}

	public void requestInitialized(ServletRequestEvent event) {
		//����requestʱ����
		HttpServletRequest request=(HttpServletRequest)event.getServletRequest();
		
		HttpSession session=request.getSession(true);//��Ӧ��session
		session.setAttribute("ip", request.getRemoteAddr());//��¼IP��ַ
		
		String uri=request.getRequestURI();//���ʵ�URL
		String[] suffix={".html",".do",".jsp",".action"};
		//ָ����׺
		for(int i=0;i<suffix.length;i++){
			if(uri.endsWith(suffix[i])){
				//�����ָ���ĺ�׺:.html,.do,.jsp,.action
				break;//�����������
			}
			if(i==suffix.length-1)
				return ;//���򷵻�
		}
		Integer activeTimes=(Integer)session.getAttribute("activeTimes");//��ȡ���ʴ���
		if(activeTimes==null){
			activeTimes=0;
		}
		session.setAttribute("activeTimes", activeTimes+1);
	}

}
