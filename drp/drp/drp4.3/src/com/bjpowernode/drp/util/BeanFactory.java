package com.bjpowernode.drp.util;
/**
 * 工厂抽象
 * @author Administrator
 *
 */
public interface BeanFactory {
	/**
	 * 根据产品编号取得具体的产品
	 * @param beanId
	 * @return
	 */
	public Object getBean(String beanId);
}
