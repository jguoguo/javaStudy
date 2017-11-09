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
 * 处理呼叫信息，生成xml文件
 * @author Administrator
 *
 */
public class HjxxServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/xml;charset=UTF-8");
		//取得日期
		String date=request.getParameter("date");
		KhfxxtManager khfxxtManage=new KhfxxtManager();
		//取得呼叫统计信息
		Hjtj hjtj=khfxxtManage.getHjtj(date);
		Document doc=DocumentHelper.createDocument();
		doc.setXMLEncoding("utf-8");
		
		Element hjxxElt=doc.addElement("hjxx");
		Element hjtjElt=hjxxElt.addElement("hjtj");
		//今日呼叫量
		hjtjElt.addElement("jrhjl").setText(String.valueOf(hjtj.getYxth()+hjtj.getWxth()));
		//有效呼叫量
		hjtjElt.addElement("yxth").setText(String.valueOf(hjtj.getYxth()));
		//无效呼叫量
		hjtjElt.addElement("wxth").setText(String.valueOf(hjtj.getWxth()));
		//有效通话成功率
		hjtjElt.addElement("yxthcgl").setText(String.valueOf(hjtj.getYxth()));
		String zt=null;
		//取得昨天
		long time;
		try {
			time = new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime()-(1000*60*60*24);
			zt=new SimpleDateFormat("yyyy-MM-dd").format(new Date(time));
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//取得明细信息
		List<Hjmx> hjmxList=khfxxtManage.getHjmxList(date);
		//呼叫明细
		Element hjmxElt=hjxxElt.addElement("hjmx");
		for(Iterator<Hjmx> iter=hjmxList.iterator();iter.hasNext();){
			Hjmx hjmx=iter.next();
			//呼叫记录
			Element hjjlElt=hjmxElt.addElement("hjjl");
			//原始号码
			hjjlElt.addElement("yshm").setText(hjmx.getKhxx().getDhhm());
			//呼叫情况
			hjjlElt.addElement("hjqk").setText(hjmx.getHjqk());
			//姓名
			hjjlElt.addElement("name").setText(hjmx.getKhxx().getName());
			
		}
		String xmlString=doc.asXML();//输出xml文件
		response.getWriter().print(xmlString);
	}

}
