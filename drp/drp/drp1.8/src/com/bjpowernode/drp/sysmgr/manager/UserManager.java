package com.bjpowernode.drp.sysmgr.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjpowernode.drp.sysmgr.domain.User;
import com.bjpowernode.drp.util.DbUtil;
import com.bjpowernode.drp.util.PageModel;

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
	/**
	 * 分页查询
	 * @param pageNo  第几页
	 * @param pageSize  每页多少条数据
	 * @return
	 */
	public PageModel findUserList(int pageNo,int pageSize){
		StringBuffer sql=new StringBuffer();
		sql.append("select user_id,user_name,password,contact_tel,email,create_date ")
			.append("from (")
				.append("select rownum as rn,user_id,user_name,password,contact_tel,email,create_date ")
				.append("from (")
					.append("select user_id,user_name,password,contact_tel,email,create_date from T_USER where user_id <> 'root' order by user_id")
				.append(") where rownum <=?")
			.append(") where rn>?");
			
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		User user=null;
		PageModel pageModel=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setInt(1, pageNo*pageSize);
			pstmt.setInt(2, (pageNo-1)*pageSize);
			rs=pstmt.executeQuery();
			List userlist=new ArrayList();
			while(rs.next()){
				user=new User();
				user.setUserId(rs.getString("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setContactTel(rs.getString("contact_tel"));
				user.setEmail(rs.getString("email"));
				user.setCreateDate(rs.getTimestamp("create_date"));
				userlist.add(user);
			}
			pageModel=new PageModel();
			pageModel.setTotalRecords(getTotalRecords(conn));
			pageModel.setList(userlist);
			pageModel.setPageSize(pageSize);
			pageModel.setPageNo(pageNo);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		return pageModel;
	}
	/**
	 * 取得总记录数
	 * @param conn
	 * @return
	 */
	private int getTotalRecords(Connection conn) throws SQLException{
		String sql="select count(*) from t_user where user_id<>'root'";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count;
		try{
			pstmt=conn.prepareStatement(sql);
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
