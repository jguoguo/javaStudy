package com.bjpowernode.drp.service.impl;



import com.bjpowernode.drp.AppException;


import com.bjpowernode.drp.PageModel;
import com.bjpowernode.drp.dao.ItemDao;
import com.bjpowernode.drp.domain.Item;
import com.bjpowernode.drp.service.ItemService;

/**
 * 采用单例模式实现
 * @author Administrator
 *
 */
public class ItemServiceImpl implements ItemService {

	private ItemDao itemDao;
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	@Override
	public void addItem(Item item) {
		try{
			itemDao.addItem(item);
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("添加物料失败！");
		}
	}

	/**
	 * 分页查询
	 */
	public PageModel findAllItem(String queryString, int pageNo, int pageSize) {
		try{
			return itemDao.findAllItem(queryString, pageNo, pageSize);
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("分页查询失败！");
		}
	}

	/**
	 * 修改物料
	 */
	public void modifyItem(Item item) {
		try{
			itemDao.modifyItem(item);
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("修改物料失败！");
		}
	}

	/**
	 * 删除物料
	 */
	public void delItem(String[] itemNos) {
		try{
			itemDao.delItem(itemNos);
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("删除物料失败！");
		}
	}

	/**
	 * 根据物料代码查询
	 */
	public Item findItemById(String itemNo) {
		try{
			return itemDao.findItemById(itemNo);
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("根据物料代码查询物料失败！");
		}
	}

	/**
	 * 保存上传文件
	 */
	public void modifyUploadFileNameField(String itemNo, String uploadFileName) {

		try{
			itemDao.modifyUploadFileNameField(itemNo,uploadFileName);
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("删除物料失败！");
		}
	}
	
}
