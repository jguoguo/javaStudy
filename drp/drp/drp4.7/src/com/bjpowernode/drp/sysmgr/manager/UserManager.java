package com.bjpowernode.drp.sysmgr.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjpowernode.drp.sysmgr.domain.User;
import com.bjpowernode.drp.util.DbUtil;
import com.bjpowernode.drp.util.PageModel;

/**
 * ���õ��������û�
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
	 * ����û�
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
	 * �����û������ѯ
	 * @param userId
	 * @return������ڷ���User���󣬷��򷵻�null
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
	 * ��ҳ��ѯ
	 * @param pageNo  �ڼ�ҳ
	 * @param pageSize  ÿҳ����������
	 * @return
	 */
	public PageModel<User> findUserList(int pageNo,int pageSize){
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
		PageModel<User> pageModel=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setInt(1, pageNo*pageSize);
			pstmt.setInt(2, (pageNo-1)*pageSize);
			rs=pstmt.executeQuery();
			List<User> userlist=new ArrayList<User>();
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
			pageModel=new PageModel<User>();
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
	 * ȡ���ܼ�¼��
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
	
	/**
	 * �޸��û�
	 * @param user
	 */
	public void modifyUser(User user){
		String sql="update t_user set user_name=?,password=?,contact_tel=?,email=? where user_id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DbUtil.getConnection();
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
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
	}
	
	/**
	 * ɾ���û�
	 * @param userId
	 */
	public void deleteUser(String userId){
		String sql="delete from t_user where user_id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
	}
	/**
	 * ����ɾ���û�
	 * ����һ��������ɾ��
	 * ֻ�ύһ��
	 * ����Statementƴ��
	 * delete from t_user where user_id in('aaaa','bbbb');
	 */
	//ʹ��statement
//	public static void delUser(String[] userIds){	
//		StringBuffer sbString=new StringBuffer();
//		for(int i=0;i<userIds.length;i++){
//			sbString.append("'")
//			.append(userIds[i])
//			.append("'")
//			.append(",");
//		}
//		String sql="delete from t_user where user_id in ("+sbString.substring(0,sbString.length()-1)+")";
//		Connection conn=null;
//		Statement stmt=null;
//		try{
//			conn=DbUtil.getConnection();
//			stmt=conn.createStatement();
//			stmt.executeUpdate(sql);
//		}catch(SQLException e){
//			e.printStackTrace();
//		}finally{
//			DbUtil.close(stmt);
//			DbUtil.close(conn);
//		}
//	}
	
	/**
	 * ����ɾ���û�
	 * ����һ��������ɾ��
	 * ֻ�ύһ��
	 * ����ռλ����ʽ
	 * delete from t_user where user_id in(��,��,��);
	 * ʹ��PreparedStatement
	 */
	public static void delUser(String[] userIds){	
		StringBuffer sbString=new StringBuffer();
		for(int i=0;i<userIds.length;i++){
			sbString.append("?");
			if(i<(userIds.length-1)){
				sbString.append(",");
			}
		}
		String sql="delete from t_user where user_id in ("+sbString.toString()+")";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			for(int i=0;i<userIds.length;i++){
				pstmt.setString(i+1, userIds[i]);
			}
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
	}
	/**
	 * ��½��֤
	 * @param userId
	 * @param password
	 * @return
	 */
	public User login(String userId,String password){
		User user=findUserById(userId);
		if(user==null){
			throw new UserNotFoundException("�û����벻��ȷ������="+userId);
		}
		if(!user.getPassword().equals(password)){
			throw new PasswordNotCorrentException("���벻��ȷ");
		}
		return user;
	}
	
	/**
	 * ��ʾsqlע�룬�����������ݣ�
	 * �û�����sdfafasdfa
	 * ���룺' or '1'='1
	 * 
	 * ���ɵ�sql���£�
	 * select * from t_user where user_id='sdfafasdfa' and password='' or '1'='1'
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
//	public boolean login(String userId,String password){
//		String sql="select * from t_user where user_id='"+userId+"' and password='"+password+"'";
//		Connection conn=null;
//		PreparedStatement pstmt=null;
//		ResultSet rs=null;
//		boolean success=false;
//		try{
//			conn=DbUtil.getConnection();
//			pstmt=conn.prepareStatement(sql);
//			rs=pstmt.executeQuery();
//			if(rs.next()){
//				System.out.println("�û�����������ȷ");
//				success=true;
//			}
//		}catch(SQLException e){
//			e.printStackTrace();
//		}finally{
//			DbUtil.close(pstmt);
//			DbUtil.close(conn);
//		}
//		return success;
//	}
	
}
