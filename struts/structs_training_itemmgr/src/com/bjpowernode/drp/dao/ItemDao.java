package com.bjpowernode.drp.dao;

import java.sql.Connection;

import com.bjpowernode.drp.PageModel;
import com.bjpowernode.drp.domain.Item;

public interface ItemDao {
	/**
	 * 添加物料
	 * @param conn
	 * @param item
	 */
	public void addItem(Connection conn,Item item);
	/**
	 * 根据id查询
	 * @param conn
	 * @param itemNO
	 * @return
	 */
	public Item findItemById(Connection conn,String itemNO);
	/**
	 * 分页查询
	 * @param conn
	 * @param queryString
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageModel findAllItem(Connection conn,String queryString, int pageNo, int pageSize);
	/**
	 * 修改物料
	 * @param conn
	 * @param item
	 */
	public void modifyItem(Connection conn,Item item);
	
	/**
	 * 删除物料
	 * @param conn
	 * @param itemNos
	 */
	public void delItem(Connection conn,String[] itemNos);
	
	/**
	 * 保存上传图片
	 * @param conn
	 * @param itemNo
	 * @param uploadFileName
	 */
	public void modifyUploadFileNameField(Connection conn,String itemNo, String uploadFileName);
}
