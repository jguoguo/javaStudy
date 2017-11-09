package com.bjpowernode.drp.sysmgr.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.bjpowernode.drp.sysmgr.domain.User;
import com.bjpowernode.drp.util.DbUtil;

/**
 * 采用单例管理用户
 * @author Administrator
 *
 */
public class UserManager {
	private static UserManager instance=new UserManager();
	private UserManager(){
		
	}
	public static UserManager getInstance(){
		return instance;
	}
	/**
	 * 添加用户
	 * @param user
	 */
	public void addUser(User user){
		String sql="insert into t_user (user_id,user_name,password,contact_tel,email,create_date) " +
				" values(?,?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getContactTel());
			pstmt.setString(5, user.getEmail());
			pstmt.setTimestamp(6, new Timestamp(new Date().getTime()));
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
	}
	
	/**
	 * 根据用户代码查询
	 * @param userId
	 * @return如果存在返回User对象，否则返回null
	 */
	public User findUserById(String userId){
		String sql="select * from t_user where user_id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		User user=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			if(rs.next()){
				user=new User();
				user.setUserId(rs.getString("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setContactTel(rs.getString("contact_tel"));
				user.setEmail(rs.getString("email"));
				user.setCreateDate(rs.getTimestamp("create_date"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		return user;
	}
}
