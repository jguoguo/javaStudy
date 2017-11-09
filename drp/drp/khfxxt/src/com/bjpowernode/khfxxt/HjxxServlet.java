package com.bjpowernode.khfxxt;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.extra.spath.ParseException;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * ���������Ϣ������xml�ļ�
 * @author Administrator
 *
 */
public class HjxxServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/xml;charset=UTF-8");
		//ȡ������
		String date=request.getParameter("date");
		KhfxxtManager khfxxtManage=new KhfxxtManager();
		//ȡ�ú���ͳ����Ϣ
		Hjtj hjtj=khfxxtManage.getHjtj(date);
		Document doc=DocumentHelper.createDocument();
		doc.setXMLEncoding("utf-8");
		
		Element hjxxElt=doc.addElement("hjxx");
		Element hjtjElt=hjxxElt.addElement("hjtj");
		//���պ�����
		hjtjElt.addElement("jrhjl").setText(String.valueOf(hjtj.getYxth()+hjtj.getWxth()));
		//��Ч������
		hjtjElt.addElement("yxth").setText(String.valueOf(hjtj.getYxth()));
		//��Ч������
		hjtjElt.addElement("wxth").setText(String.valueOf(hjtj.getWxth()));
		//��Чͨ���ɹ���
		hjtjElt.addElement("yxthcgl").setText(String.valueOf(hjtj.getYxth()));
		String zt=null;
		//ȡ������
		long time;
		try {
			time = new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime()-(1000*60*60*24);
			zt=new SimpleDateFormat("yyyy-MM-dd").format(new Date(time));
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ȡ����ϸ��Ϣ
		List<Hjmx> hjmxList=khfxxtManage.getHjmxList(date);
		//������ϸ
		Element hjmxElt=hjxxElt.addElement("hjmx");
		for(Iterator<Hjmx> iter=hjmxList.iterator();iter.hasNext();){
			Hjmx hjmx=iter.next();
			//���м�¼
			Element hjjlElt=hjmxElt.addElement("hjjl");
			//ԭʼ����
			hjjlElt.addElement("yshm").setText(hjmx.getKhxx().getDhhm());
			//�������
			hjjlElt.addElement("hjqk").setText(hjmx.getHjqk());
			//����
			hjjlElt.addElement("name").setText(hjmx.getKhxx().getName());
			
		}
		String xmlString=doc.asXML();//���xml�ļ�
		response.getWriter().print(xmlString);
	}

}
