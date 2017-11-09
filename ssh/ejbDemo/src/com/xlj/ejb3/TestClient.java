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
			//获取JBoss上下文环境对象
			Context ctx=getInitialContext();
			//根据JNDI查找部署HelloEJBService组件
			Object object=ctx.lookup("HelloEJBService/remote");
			//检查是否是实现了指定的业务接口
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
