package com.bjpowernode.drp.dao;



import org.hibernate.Session;

import com.bjpowernode.drp.PageModel;
import com.bjpowernode.drp.domain.Item;

public interface ItemDao {
	/**
	 * 添加物料
	 * 
	 * @param item
	 */
	public void addItem(Item item);
	/**
	 * 根据id查询
	 * 
	 * @param itemNO
	 * @return
	 */
	public Item findItemById(String itemNO);
	/**
	 * 分页查询
	 * 
	 * @param queryString
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageModel findAllItem(String queryString, int pageNo, int pageSize);
	/**
	 * 修改物料
	 * 
	 * @param item
	 */
	public void modifyItem(Item item);
	
	/**
	 * 删除物料
	 * 
	 * @param itemNos
	 */
	public void delItem(String[] itemNos);
	
	/**
	 * 保存上传图片
	 * 
	 * @param itemNo
	 * @param uploadFileName
	 */
	public void modifyUploadFileNameField(String itemNo, String uploadFileName);
}
