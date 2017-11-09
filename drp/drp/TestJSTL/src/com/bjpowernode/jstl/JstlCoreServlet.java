package com.bjpowernode.jstl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试JSTL核心库
 * @author Administrator
 *
 */
public class JstlCoreServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//普通字符串
		request.setAttribute("hello", "hello world");
		//HTML字符串
		request.setAttribute("welcome", "<font color='red'>欢迎你来到这个世界</font>");
		
		//条件控制标签
		request.setAttribute("v1", 10);
		request.setAttribute("v2", 20);
		request.setAttribute("userList", new ArrayList());
		
		//结构
		Group group=new Group();
		group.setName("动力节点");
		List users=new ArrayList();
		for(int i=0;i<10;i++){
			User usr=new User();
			usr.setUsername("张三_"+i);
			usr.setAge(23+i);
			usr.setGroup(group);
			users.add(usr);
		}
		request.setAttribute("users", users);
		
		Map map=new HashMap();
		map.put("k1", "v1");
		map.put("k2", "v2");
		map.put("k3", "v3");
		map.put("k4", "v4");
		request.setAttribute("map", map);
		
		//forTokens
		request.setAttribute("strTokens", "1#2#3#4#5");
		request.getRequestDispatcher("/jstl_core.jsp").forward(request, response);
	}

}
