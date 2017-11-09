package test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjpowernode.spring.Bean1;


import junit.framework.TestCase;

public class ScopeTest extends TestCase {

	private BeanFactory factory;
	@Override
	protected void setUp() throws Exception {

		factory=new ClassPathXmlApplicationContext("applicationContext-beans.xml");
	}
	
	public void testScope(){
		Bean1 bean11=(Bean1)factory.getBean("bean1");
		Bean1 bean12=(Bean1)factory.getBean("bean1");
		System.out.println(bean11==bean12);
	}
}
