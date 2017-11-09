package com.bjpowernode.drp.statreport.manager.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.bjpowernode.drp.statreport.manager.StatReportManager;
import com.bjpowernode.drp.util.ApplicationException;
import com.bjpowernode.drp.util.ConnectionManager;

public class StatReportManagerImpl implements StatReportManager {

	@Override
	public Map<String, Integer> getClientLevelCount() {
		
		String sql="select a.name,count(b.client_level_id) as c from t_data_dict a left join t_client b on a.id=b.client_level_id where a.category='A' group by a.name";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Map<String,Integer> map=new HashMap<String,Integer>();
		try{
			pstmt=ConnectionManager.getConnection().prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				map.put(rs.getString("name"), rs.getInt("c"));//将数据放入map中
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new ApplicationException("生成分销商等级分布图失败");
		}finally{
			ConnectionManager.close(rs);
			ConnectionManager.close(pstmt);
		}
		return map;
	}

}
