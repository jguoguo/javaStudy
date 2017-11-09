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
 * ����EL���ʽ
 * @author Administrator
 *
 */
public class JSTLServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ͨ�ַ���
		request.setAttribute("hello", "Hello World");
		
		//�ṹ
		Group group=new Group();
		group.setName("�����ڵ�");
		User user=new User();
		user.setUsername("����");
		user.setAge(23);
		user.setGroup(group);
		request.setAttribute("user", user);
		
		Map map=new HashMap();
		map.put("k1", "v1");
		map.put("k2", "v2");
		request.setAttribute("map", map);
		
		//�ַ�������
		String[] strArray=new String[]{"a","b","c"};
		request.setAttribute("strArray", strArray);
		
		//��������
		User[] users=new User[10];
		for(int i=0;i<users.length;i++){
			users[i]=new User();
			users[i].setUsername("����_"+i);
		}
		request.setAttribute("users", users);
		
		//list
		List userList=new ArrayList();
		for(int i=0;i<10;i++){
			User usr=new User();
			usr.setUsername("����_"+i);
			userList.add(usr);
		}
		request.setAttribute("userList", userList);
		
		//empty
		request.setAttribute("v2", "");
		request.setAttribute("v3", new ArrayList());
		request.setAttribute("v4", "12345");
		request.setAttribute("v5", null);
		request.getRequestDispatcher("/jstl_el.jsp").forward(request, response);
	}

}
