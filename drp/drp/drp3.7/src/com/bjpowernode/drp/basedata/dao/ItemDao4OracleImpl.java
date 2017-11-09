package com.bjpowernode.drp.basedata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bjpowernode.drp.basedata.domain.Item;
import com.bjpowernode.drp.util.ApplicationException;
import com.bjpowernode.drp.util.DbUtil;
import com.bjpowernode.drp.util.PageModel;
import com.bjpowernode.drp.util.datadict.domain.ItemCategory;
import com.bjpowernode.drp.util.datadict.domain.ItemUnit;

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
			e.printStackTrace();
			//System.out.println(e.getErrorCode());
//			if(e.getErrorCode()==1){
//				throw new ApplicationException("物料代码已经存在，代码为【"+item.getItemNo()+"】");
//			}
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
		StringBuffer sbSql=new StringBuffer();
		sbSql.append("select i.item_no,i.item_name ,i.item_category_id, d1.name as item_category_name,i.item_unit_id,d2.name as item_unit_name,")
			.append("i.spec,i.pattern ")
			.append("from t_items i,t_data_dict d1,t_data_dict d2 ")
			.append("where i.item_category_id=d1.id and i.item_unit_id=d2.id and i.item_no=?");
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Item item=null;
		try{
			pstmt=conn.prepareStatement(sbSql.toString());
			pstmt.setString(1, itemNo);
			rs=pstmt.executeQuery();
			while(rs.next()){
				item=new Item();
				item.setItemNo(rs.getString("item_no"));
				item.setItemName(rs.getString("item_name"));
				item.setSpec(rs.getString("spec"));
				item.setPattern(rs.getString("pattern"));
				ItemCategory ic=new ItemCategory();
				ic.setId(rs.getString("item_category_id"));
				ic.setName(rs.getString("item_category_name"));
				item.setItemCategory(ic);
				ItemUnit iu=new ItemUnit();
				iu.setId(rs.getString("item_unit_id"));
				iu.setName(rs.getString("item_unit_name"));
				item.setItemUnit(iu);
			}
		}catch(SQLException e){
			
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
		return item;
	}

	@Override
	public PageModel fingItemList(Connection conn,int pageNo, int pageSize, String condation) {
		// TODO Auto-generated method stub
		return null;
	}

}
