package test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjpowernode.spring.Bean2;


import junit.framework.TestCase;

public class AutoWireTest extends TestCase {

	private BeanFactory factory;
	@Override
	protected void setUp() throws Exception {
		
		factory=new ClassPathXmlApplicationContext("applicationContext-beans.xml");
	}

	
	public void testInjection1(){
		Bean2 bean2= (Bean2)factory.getBean("bean2");
		System.out.println("bean2.bean3.id="+bean2.getBean3().getId());
		System.out.println("bean2.bean3.name="+bean2.getBean3().getName());
		System.out.println("bean2.bean3.sex="+bean2.getBean3().getSex());
		System.out.println("bean2.bean4.id="+bean2.getBean4().getId());
		System.out.println("bean2.bean4.name="+bean2.getBean4().getName());
		System.out.println("bean2.bean4.sex="+bean2.getBean4().getSex());
		System.out.println("bean2.bean4.age="+bean2.getBean4().getAge());
		System.out.println("bean2.bean5.password="+bean2.getBean5().getPassword());
	}
}
