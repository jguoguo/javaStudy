package com.bjpowernode.drp.basedata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bjpowernode.drp.basedata.domain.Client;
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

	/**
	 * 删除物料
	 */
	@Override
	public void delItem(Connection conn, String[] itemNos) {
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<itemNos.length;i++){
			sb.append("?");
			if(i<(itemNos.length-1)){
				sb.append(",");
			}
		}
		String sql="delete from t_items where item_no in ("+sb.toString()+")";
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql);
			for(int i=0;i<itemNos.length;i++){
				pstmt.setString(i+1, itemNos[i]);
			}
			pstmt.executeUpdate();
		}catch(SQLException e){
			throw new ApplicationException("删除物料失败");
		}finally{
			DbUtil.close(pstmt);
		}
		

	}

	@Override
	public void modifyItem(Connection conn, Item item) {
		String sql="update t_items set item_name=?,spec=?,pattern=?,item_category_id=?,item_unit_id=?,file_name=? where item_no=?";
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, item.getItemName());
			pstmt.setString(2, item.getSpec());
			pstmt.setString(3, item.getPattern());
			pstmt.setString(4, item.getItemCategory().getId());
			pstmt.setString(5, item.getItemUnit().getId());
			pstmt.setString(6, item.getFileName());
			pstmt.setString(7, item.getItemNo());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			throw new ApplicationException("修改物料失败");
		}finally{
			DbUtil.close(pstmt);
		}
	}

	@Override
	public Item findItemById(Connection conn, String itemNo) {
		StringBuffer sbSql=new StringBuffer();
		sbSql.append("select i.item_no,i.item_name ,i.item_category_id, d1.name as item_category_name,i.item_unit_id,d2.name as item_unit_name,")
			.append("i.spec,i.pattern,i.file_name ")
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
				item.setFileName(rs.getString("file_name"));
			}
		}catch(SQLException e){
			throw new ApplicationException("根据物料代码查询出错，物料代码["+itemNo+"]");
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
		return item;
	}

	@Override
	public PageModel fingItemList(Connection conn,int pageNo, int pageSize, String condation) {
		// TODO Auto-generated method stub
		StringBuffer sbSql=new StringBuffer();
		sbSql.append("select * ")
			.append("from ( ")
			.append("select i.*,rownum rn from (")
			.append("select a.item_no,a.item_name,a.spec,a.pattern,a.item_category_id, ")
			.append("b.name as item_category_name,a.item_unit_id,a.file_name,c.name as item_unit_name ")
			.append("from t_items a ,t_data_dict b,t_data_dict c ")
			.append("where a.item_category_id=b.id and a.item_unit_id=c.id ");
			if((condation!=null)&& !"".equals(condation)){
				sbSql.append("and (a.item_no like '"+condation +"%' or a.item_name like '"+condation +"%') ");
			}
			sbSql.append("order by a.item_no")
				.append(") i where rownum <=? ")
				.append(") ")
				.append("where rn>?");
		//System.out.println("sql="+sbSql.toString());
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		PageModel<Item> pageModel=null;
		List<Item> list=new ArrayList<Item>();
//		int count=0;
		try{
			pstmt=conn.prepareStatement(sbSql.toString());
			pstmt.setInt(1, pageNo*pageSize);
			pstmt.setInt(2, (pageNo-1)*pageSize);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Item item=new Item();
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
				item.setFileName(rs.getString("file_name"));
				list.add(item);
			}
			pageModel=new PageModel<Item>();
			pageModel.setList(list);
			pageModel.setPageNo(pageNo);
			pageModel.setPageSize(pageSize);
			pageModel.setTotalRecords(getTotalRecords(conn,condation));
		}catch(SQLException e){
			throw new ApplicationException("分页查询失败");
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
		
		return pageModel;
	}
	/**
	 * 取得总记录数
	 * @param conn
	 * @return
	 */
	private int getTotalRecords(Connection conn,String condation) throws SQLException{
		StringBuffer sql=new StringBuffer();
		sql.append("select count(*) from (select a.item_no,a.item_name,a.spec,a.pattern,a.item_category_id, b.name as item_category_name,a.item_unit_id,c.name as item_unit_name from t_items a ,t_data_dict b,t_data_dict c where a.item_category_id=b.id and a.item_unit_id=c.id  ");
		if((condation!=null)&& !"".equals(condation)){
			sql.append("and (a.item_no like '"+condation +"%' or a.item_name like '"+condation +"%') ");
		}
		sql.append("order by a.item_no )");
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count;
		try{
			pstmt=conn.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			rs.next();
			count=rs.getInt(1);
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
		return count;
	}

}
