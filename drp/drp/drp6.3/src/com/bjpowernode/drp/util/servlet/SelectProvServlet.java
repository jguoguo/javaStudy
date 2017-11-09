package com.bjpowernode.drp.util.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.bjpowernode.drp.basedata.manager.ClientManager;

/**
 * 下拉联动，根据区域代码选择省
 * @author Administrator
 *
 */
public class SelectProvServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/xml;charset=UTF-8");
		int regionId=Integer.parseInt(request.getParameter("regionId"));
		if(regionId !=0){
			Map map=ClientManager.getInstance().getProvByRegion(regionId);
			Document doc=DocumentHelper.createDocument();
			Element rootElt=doc.addElement("items");
			for(Iterator<Map.Entry> iter=map.entrySet().iterator();iter.hasNext();){
				Map.Entry<Integer,String> entry=(Map.Entry)iter.next();
				
				Element itemElt=rootElt.addElement("item");
				Element idElt=itemElt.addElement("id");
				idElt.setText(entry.getKey().toString());
				Element nameElt=itemElt.addElement("name");
				nameElt.setText(entry.getValue());			
			}
			String xmlString=doc.asXML();//输出xml文件
			response.getWriter().print(xmlString);
		}

	}

}
