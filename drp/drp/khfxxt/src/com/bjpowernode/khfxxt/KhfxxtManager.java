package com.bjpowernode.khfxxt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhfxxtManager {
	
	/**
	 * 根据日期返回呼叫统计信息
	 * @param rq
	 * @return
	 */
	public Hjtj getHjtj(String date){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from t_hjtjb where rq=?";
		Hjtj hjtj=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, date);
			rs=pstmt.executeQuery();
			if(rs.next()){
				hjtj=new Hjtj();
				hjtj.setDate(date);
				hjtj.setYxth(rs.getInt("yxth"));
				hjtj.setWxth(rs.getInt("wxth"));
				hjtj.setQzyxkh(rs.getInt("qzyxkh"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		return hjtj;
	}
	
	/**
	 * 根据日期返回呼叫明细表
	 * @param rq
	 * @return
	 */
	public List<Hjmx> getHjmxList(String date){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select a.xh,a.rq,a.hjqk,b.dhhm,b.name from t_hjmxb a ,t_khxxb b where a.dhhm=b.dhhm and a.rq=?";
		Hjmx hjmx=null;
		List<Hjmx> list=new ArrayList<Hjmx>();
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, date);
			rs=pstmt.executeQuery();
			while(rs.next()){
				hjmx=new Hjmx();
				hjmx.setNumber(rs.getInt("xh"));
				hjmx.setDate(rs.getString("rq"));
				hjmx.setHjqk(rs.getString("hjqk"));
				Khxx khxx=new Khxx();
				khxx.setDhhm(rs.getString("dhhm"));
				khxx.setName(rs.getString("name"));
				hjmx.setKhxx(khxx);
				list.add(hjmx);
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
