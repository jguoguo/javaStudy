package com.bjpowernode.drp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 采用ThreadLocal封装Connection
 * @author Administrator
 *
 */
public class ConnectionManager {
	
	public static ThreadLocal<Connection> connectionHolder=new ThreadLocal<Connection>();
	/**
	 * 得到Connection
	 * @return
	 */
	public static Connection getConnection(){
		
		Connection conn=connectionHolder.get();
		if(conn==null){
			try {
				JdbcConfig jdbcConfig=XmlConfigReader.getInstance().getJdbcConfig();
				Class.forName(jdbcConfig.getDriverName());
				conn=DriverManager.getConnection(jdbcConfig.getUrl(),jdbcConfig.getUserName(),jdbcConfig.getPassword());
				//将conn设置到当前ThreadLocal，防止多线程都操作同一个对象
				connectionHolder.set(conn);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new ApplicationException("系统错误，请联系系统管理员");
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ApplicationException("系统错误，请联系系统管理员");
			}
		}
		return conn;
	}
	public static void closeConnection(){
		Connection conn=connectionHolder.get();
		if(conn!=null){
			try{
				conn.close();
				//从ThreadLocal中清除Connection
				connectionHolder.remove();
			}catch(SQLException e){
				e.printStackTrace();
			}
			
		}
	}
	
	/**
	 * 停止自动提交
	 * @param conn
	 */
	public static void beginTransaction(Connection conn){
		if(conn!=null){
			try {
				if(conn.getAutoCommit()){
					conn.setAutoCommit(false);//手动提交
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 手动提交事务
	 * @param conn
	 */
	public static void commitTransaction(Connection conn){
		
		try {
			if(conn!=null){
				if(!conn.getAutoCommit()){
					conn.commit();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 回滚事务
	 * @param conn
	 */
	public static void rollbackTransaction(Connection conn){
		try{
			if(conn!=null){
				if(!conn.getAutoCommit()){
					conn.rollback();
				}
			}
		}catch(SQLException e){

		}
	}
	/**
	 * 恢复到原来状态
	 * @param conn
	 */
	public static void resetConnection(Connection conn){
		try{
			if(conn!=null){
				if(conn.getAutoCommit()){
					conn.setAutoCommit(false);
				}else{
					conn.setAutoCommit(true);
				}
			}
		}catch(SQLException e){}
	}
	
	public static void close(Statement pstmt){
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
