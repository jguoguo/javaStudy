package com.xlj.ejb3;

import javax.ejb.Remote;

/**��עΪ@RemoteԶ�̽ӿ�*/
@Remote
public interface IHelloEJBService {

	public String sayHelloEJB(String name);
}
