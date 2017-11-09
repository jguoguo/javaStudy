package com.bjpowernode.drp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bjpowernode.drp.DBUtil;
import com.bjpowernode.drp.domain.ItemCategory;
import com.bjpowernode.drp.domain.ItemUnit;

public class DataDictServiceImpl implements DataDictService {
	/**
	 * 取得物料类别代码列表
	 */
	@Override
	public List<ItemCategory> getItemCategoryList() {
		String sql="select id,name from t_data_dict where category='C'";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ItemCategory> itemCategoryList=new ArrayList<ItemCategory>();
		try{
			conn=DBUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				ItemCategory ic=new ItemCategory();
				ic.setId(rs.getString("id"));
				ic.setName(rs.getString("name"));
				itemCategoryList.add(ic);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return itemCategoryList;
	}

	@Override
	public List<ItemUnit> getItemUnitList() {
		String sql="select id,name from t_data_dict where category='D'";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ItemUnit> itemUnitList=new ArrayList<ItemUnit>();
		try{
			conn=DBUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				ItemUnit iu=new ItemUnit();
				iu.setId(rs.getString("id"));
				iu.setName(rs.getString("name"));
				itemUnitList.add(iu);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return itemUnitList;
	}

}
