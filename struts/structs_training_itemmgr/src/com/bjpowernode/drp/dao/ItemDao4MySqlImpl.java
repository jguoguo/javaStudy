package com.bjpowernode.drp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bjpowernode.drp.DBUtil;
import com.bjpowernode.drp.PageModel;
import com.bjpowernode.drp.domain.Item;
import com.bjpowernode.drp.domain.ItemCategory;
import com.bjpowernode.drp.domain.ItemUnit;

public class ItemDao4MySqlImpl implements ItemDao{

	
	public void addItem(Connection conn, Item item) {
		// TODO Auto-generated method stub
		String sql="insert into t_items(item_no,item_name,spec,pattern,category,unit) " +
				"values(?,?,?,?,?,?)";
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
			//取得主键重复的错误码
			if(e.getErrorCode()==1){
				
			}
		}finally{
			DBUtil.close(pstmt);
		}
	}

	
	public Item findItemById(Connection conn, String itemNO) {
		// TODO Auto-generated method stub
		StringBuffer sbSql=new StringBuffer();
		sbSql.append("select a.item_no,a.item_name,a.spec,a.pattern,a.category as category_id, ")
			 .append("b.name as category_name,a.unit as unit_id,c.name as unit_name,a.upload_file_name ")
			 .append("from t_items a,t_data_dict b,t_data_dict c ")
			 .append("where a.category=b.id and a.unit=c.id and a.item_no=?");
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Item item=null;
		try{
			pstmt=conn.prepareStatement(sbSql.toString());
			pstmt.setString(1, itemNO);
			rs=pstmt.executeQuery();
			if(rs.next()){
				item=new Item();
				item.setItemNo(rs.getString("item_no"));
				item.setItemName(rs.getString("item_name"));
				item.setSpec(rs.getString("spec"));
				item.setPattern(rs.getString("pattern"));
				//构造ItemCategory
				ItemCategory ic=new ItemCategory();
				ic.setId(rs.getString("category_id"));
				ic.setName(rs.getString("category_name"));
				item.setItemCategory(ic);
				//构造ItemUnit
				ItemUnit iu=new ItemUnit();
				iu.setId(rs.getString("unit_id"));
				iu.setName(rs.getString("unit_name"));
				item.setItemUnit(iu);
				//上传文件名称
				item.setUploadFileName(rs.getString("upload_file_name"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs);
			DBUtil.close(pstmt);
		}
		return item;
	}

	
	public PageModel findAllItem(Connection conn, String queryString,
			int pageNo, int pageSize) {
		StringBuffer sbSql = new StringBuffer();
		sbSql.append("select a.item_no, a.item_name, a.spec, a.pattern, a.category as category_id, ")
		.append("b.name as category_name, a.unit as unit_id, c.name as unit_name ")
		.append("from t_items a, t_data_dict b, t_data_dict c ")
		.append("where a.category=b.id and a.unit=c.id  ");
		if (queryString != null && !"".equals(queryString)) {
			sbSql.append(" and (a.item_no like '" + queryString + "%' or a.item_name like '" + queryString + "%') ");
		}
		sbSql.append(" order by a.item_no limit ?, ?");
		System.out.println("sql=" + sbSql.toString());
		//通常采用日志组件记录，如log4j, 级别：info,debug,error...
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PageModel pageModel = null;
		try {
			pstmt = conn.prepareStatement(sbSql.toString());
			pstmt.setInt(1, (pageNo -1 ) * pageSize);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			List itemList = new ArrayList();
			while (rs.next()) {
				Item item = new Item();
				item.setItemNo(rs.getString("item_no"));
				item.setItemName(rs.getString("item_name"));
				item.setSpec(rs.getString("spec"));
				item.setPattern(rs.getString("pattern"));
				//构造ItemCategory
				ItemCategory ic = new ItemCategory();
				ic.setId(rs.getString("category_id"));
				ic.setName(rs.getString("category_name"));
				item.setItemCategory(ic);
				
				//构造ItemUnit
				ItemUnit iu = new ItemUnit();
				iu.setId(rs.getString("unit_id"));
				iu.setName(rs.getString("unit_name"));
				item.setItemUnit(iu);
				
				itemList.add(item);
			}
			pageModel = new PageModel();
			pageModel.setPageNo(pageNo);
			pageModel.setPageSize(pageSize);
			pageModel.setList(itemList);
			//根据条件取得记录数
			int totalRecords = getTotalRecords(conn, queryString);
			pageModel.setTotalRecords(totalRecords);
		}catch(SQLException e) {
			e.printStackTrace();
			//记录到日志文件 error
			//throw new AppException("分页查询失败");
		}finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
		}
		return pageModel;
	}
	
	/**
	 * 根据条件取得记录数
	 * @param conn
	 * @param queryStr
	 * @return
	 */
	private int getTotalRecords(Connection conn, String queryStr) 
	throws SQLException {
		String sql = "select count(*) from t_items ";
		if (queryStr != null && !"".equals(queryStr)) {
			sql+="where item_no like '" + queryStr + "%' or item_name like '" + queryStr + "%' ";
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int temp = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			temp = rs.getInt(1);
		}finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
		}
		return temp;
	}

	
	public void modifyItem(Connection conn, Item item) {
		String sql = "update t_items set item_name=?, spec=?, pattern=?, category=?, unit=? " +
		"where item_no=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, item.getItemName());
			pstmt.setString(2, item.getSpec());
			pstmt.setString(3, item.getPattern());
			pstmt.setString(4, item.getItemCategory().getId());
			pstmt.setString(5, item.getItemUnit().getId());
			pstmt.setString(6, item.getItemNo());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			//log4j记录日志
			e.printStackTrace();
			//throw new AppException("修改物料失败！");
		}finally {
			DBUtil.close(pstmt);
		}
		
	}

	
	public void delItem(Connection conn, String[] itemNos) {
		StringBuffer sbStr = new StringBuffer();
		for (int i=0; i<itemNos.length; i++) {
			sbStr.append("?,");
		}
		String sql = "delete from t_items where item_no in(" + sbStr.substring(0, sbStr.length() - 1) + ")";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i=0; i<itemNos.length; i++) {
				pstmt.setString(i+1, itemNos[i]);
			}
			pstmt.executeUpdate();
		}catch(SQLException e) {
			//log4j记录日志
			e.printStackTrace();
			//throw new AppException("删除物料失败！");
		}finally {
			DBUtil.close(pstmt);
		}	
	}

	
	public void modifyUploadFileNameField(Connection conn, String itemNo,
			String uploadFileName) {
		String sql = "update t_items set upload_file_name=? where item_no=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uploadFileName);
			pstmt.setString(2, itemNo);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			//log4j记录日志
			e.printStackTrace();
			//throw new AppException("修改上传文件失败！");
		}finally {
			DBUtil.close(pstmt);
		}
		
	}

}
