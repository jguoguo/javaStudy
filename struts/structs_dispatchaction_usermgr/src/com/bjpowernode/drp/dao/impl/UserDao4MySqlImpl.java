package com.bjpowernode.drp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.bjpowernode.drp.DBUtil;
import com.bjpowernode.drp.dao.UserDao;
import com.bjpowernode.drp.model.User;

/**
 * 用户增删改查Dao层MySql实现
 *
 */
public class UserDao4MySqlImpl implements UserDao {
	
	/**
	 * 增加用户
	 */
	@Override
	public void addUser(Connection conn, User user) {
		// TODO Auto-generated method stub
		String sql="insert into t_user(user_id,user_name,password,contact_tel,email,create_date) " +
				"values(?,?,?,?,?,?)";
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getContactTel());
			pstmt.setString(5, user.getEmail());
			pstmt.setTimestamp(6, new Timestamp(user.getCreateDate().getTime()));
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.closeStmt(pstmt);
		}
	}

	/**
	 * 根据userId的集合删除用户
	 */
	@Override
	public void deleteUsers(Connection conn, String[] userList) {
		// TODO Auto-generated method stub
		StringBuffer sbfSql=new StringBuffer();
		for(int i=0;i<userList.length;i++){
			sbfSql.append("dgsdf")
				.append(userList[i])
				.append("'")
				.append(",");
		}
		String sql="delete from t_user where user_id in ("+sbfSql.substring(0, sbfSql.length()-1)+")";
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
		
	}
	/**
	 * 修改用户信息
	 */
	@Override
	public void modifyUser(Connection conn, User user) {
		
		String sql="update t_user set user_name=?,password=?,contact_tel=?,email=? where user_id=?";
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getContactTel());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getUserId());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.closeStmt(pstmt);
		}
	}

	
	/**
	 * 根据用户ID查找用户
	 */
	@Override
	public User findUserById(String userId) {
		// TODO Auto-generated method stub
		String sql="select * from t_user where user_id=?";
		User user=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=DBUtil.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();//保存查询的结果
			if(rs.next()){
				user=new User();
				user.setUserId(rs.getString("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setContactTel(rs.getString("contact_tel"));
				user.setEmail(rs.getString("email"));
				user.setCreateDate(rs.getTimestamp("create_time"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.closeRs(rs);
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return user;
	}
	/**
	 * 查找所有用户
	 */
	@Override
	public List findAllUserList() {
		// TODO Auto-generated method stub
		String sql="select * from t_user where user_id <> 'root' order by user_id";
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		List userList=new ArrayList();
		try{
			conn=DBUtil.getConn();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				User user=new User();
				user.setUserId(rs.getString("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setContactTel(rs.getString("contact_tel"));
				user.setEmail(rs.getString("email"));
				user.setCreateDate(rs.getTimestamp("create_time"));
				userList.add(user);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.closeStmt(stmt);
			DBUtil.closeRs(rs);
			DBUtil.closeConn(conn);
		}
		return userList;
	}

}
