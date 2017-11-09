package com.bjpowernode.drp.basedata.manager;

public class ClientManager {
	private static ClientManager instance=new ClientManager();
	private ClientManager(){}
	public static ClientManager getInstance(){
		return instance;
	}
	/**
	 * ·µ»ØHTML×Ö·û´®
	 * @return
	 */
	public String getClientTreeHTMLString(){
		return new ClientTreeReader().getClientTreeHTMLString();
	}
}
