package com.bjpowernode.drp.statreport.manager;

import java.util.Map;

/**
 * ͳ�Ʊ�����ؽӿ�
 * @author Administrator
 *
 */
public interface StatReportManager {

	/**
	 * ȡ�÷����̼������
	 * @return Map(key="һ��������",value=100;key="����������",value=200;
	 * key="����������",value=0��
	 */
	public Map<String,Integer> getClientLevelCount();
}
