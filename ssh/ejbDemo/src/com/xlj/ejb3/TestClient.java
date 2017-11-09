package com.xlj.ejb3;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

public class TestClient {
	private static Context context;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			//��ȡJBoss�����Ļ�������
			Context ctx=getInitialContext();
			//����JNDI���Ҳ���HelloEJBService���
			Object object=ctx.lookup("HelloEJBService/remote");
			//����Ƿ���ʵ����ָ����ҵ��ӿ�
			IHelloEJBService service=(IHelloEJBService)PortableRemoteObject.narrow(object, IHelloEJBService.class);
			System.out.println(service.sayHelloEJB("Client"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private static Context getInitialContext() throws NamingException {
		if(context==null){
			Hashtable props=new Hashtable();
			props.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
			props.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
			props.put(Context.PROVIDER_URL,"jnp://localhost:1099");
			context=new InitialContext(props);
		}
		
		return context;
	}

}
