package com.bjpowernode.drp.dao;



import org.hibernate.Session;

import com.bjpowernode.drp.PageModel;
import com.bjpowernode.drp.domain.Item;

public interface ItemDao {
	/**
	 * 添加物料
	 * @param session
	 * @param item
	 */
	public void addItem(Session session,Item item);
	/**
	 * 根据id查询
	 * @param session
	 * @param itemNO
	 * @return
	 */
	public Item findItemById(Session session,String itemNO);
	/**
	 * 分页查询
	 * @param session
	 * @param queryString
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageModel findAllItem(Session session,String queryString, int pageNo, int pageSize);
	/**
	 * 修改物料
	 * @param session
	 * @param item
	 */
	public void modifyItem(Session session,Item item);
	
	/**
	 * 删除物料
	 * @param session
	 * @param itemNos
	 */
	public void delItem(Session session,String[] itemNos);
	
	/**
	 * 保存上传图片
	 * @param session
	 * @param itemNo
	 * @param uploadFileName
	 */
	public void modifyUploadFileNameField(Session session,String itemNo, String uploadFileName);
}
