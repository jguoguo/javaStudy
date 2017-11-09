package com.xlj.ejb3;

import javax.ejb.Stateless;

@Stateless
public class HelloEJBService implements IHelloEJBService {

	@Override
	public String sayHelloEJB(String name) {
		String msg="Hello"+name+",Welcome to EJB world!";
		return msg;
	}

}
