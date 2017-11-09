package com.bjpowernode.drp.basedata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bjpowernode.drp.basedata.domain.Item;
import com.bjpowernode.drp.util.ApplicationException;
import com.bjpowernode.drp.util.DbUtil;
import com.bjpowernode.drp.util.PageModel;

public class ItemDao4OracleImpl implements ItemDao {

	@Override
	public void addItem(Connection conn, Item item) {
		String sql="insert into t_items (item_no,item_name,spec,pattern,item_category_id,item_unit_id) " +
				"values (?,?,?,?,?,?)";
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, item.getItemNo());
			pstmt.setString(2, item.getItemName());
			pstmt.setString(3, item.getSpec());
			pstmt.setString(4, item.getPattern());
			pstmt.setString(5, item.getItemCategory().getId());
			pstmt.setString(6, item.getItemUnit().getId());
			pstmt.executeUpdate();
		}catch(SQLException e){
			//e.printStackTrace();
			//System.out.println(e.getErrorCode());
			if(e.getErrorCode()==1){
				throw new ApplicationException("物料代码已经存在，代码为【"+item.getItemNo()+"】");
			}
			throw new ApplicationException("添加物料失败");
		}finally{
			DbUtil.close(pstmt);
		}
		
	}

	@Override
	public void delItem(Connection conn, String[] itemNos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyItem(Connection conn, Item item) {
		// TODO Auto-generated method stub

	}

	@Override
	public Item findItemById(Connection conn, String itemNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageModel fingItemList(Connection conn,int pageNo, int pageSize, String condation) {
		// TODO Auto-generated method stub
		return null;
	}

}
