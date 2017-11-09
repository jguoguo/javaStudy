package com.bjpowernode.drp.util.datadict.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bjpowernode.drp.util.DbUtil;
import com.bjpowernode.drp.util.datadict.domain.ClientLevel;
import com.bjpowernode.drp.util.datadict.domain.ItemCategory;
import com.bjpowernode.drp.util.datadict.domain.ItemUnit;

/**
 * ���õ������
 * @author Administrator
 *
 */
public class DataDictManager {
	
	private static DataDictManager instance =new DataDictManager();
	private DataDictManager(){}
	public static DataDictManager getInstance(){
		
		return instance;
	}
	/**
	 * ȡ�÷����̼����б�
	 * @return
	 */
	public List<ClientLevel> findClientLevelList(String category){
		String sql="select * from t_data_dict where category=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ClientLevel> list=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, category);
			rs=pstmt.executeQuery();
			list=new ArrayList<ClientLevel>();
			while(rs.next()){
				ClientLevel clientlevel=new ClientLevel();
				clientlevel.setId(rs.getString("id"));
				clientlevel.setName(rs.getString("name"));
				list.add(clientlevel);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		return list;
	}
	/**
	 * ȡ����������б�
	 * @param category
	 * @return
	 */
	public List<ItemCategory> findItemCategoryList(){
		String sql="select * from t_data_dict where category='C'";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ItemCategory> list=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			list=new ArrayList<ItemCategory>();
			while(rs.next()){
				ItemCategory ic=new ItemCategory();
				ic.setId(rs.getString("id"));
				ic.setName(rs.getString("name"));
				list.add(ic);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		return list;
	}
	public List<ItemUnit> findItemUnitList(){
		String sql="select * from t_data_dict where category='D'";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ItemUnit> list=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			list=new ArrayList<ItemUnit>();
			while(rs.next()){
				ItemUnit iu=new ItemUnit();
				iu.setId(rs.getString("id"));
				iu.setName(rs.getString("name"));
				list.add(iu);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		return list;
	}
}
