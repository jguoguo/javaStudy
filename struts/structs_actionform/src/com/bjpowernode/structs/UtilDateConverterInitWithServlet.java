package com.bjpowernode.structs;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.beanutils.ConvertUtils;

public class UtilDateConverterInitWithServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("UtilDateConverterInitWithServlet");
		ConvertUtils.register(new UtilDateConverter(), java.util.Date.class);
	}

}
