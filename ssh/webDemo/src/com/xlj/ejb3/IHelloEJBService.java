package com.xlj.ejb3;

import javax.ejb.Remote;

/**标注为@Remote远程接口*/
@Remote
public interface IHelloEJBService {

	public String sayHelloEJB(String name);
}
