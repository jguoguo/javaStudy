package com.bjpowernode.drp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ����ThreadLocal��װConnection
 * @author Administrator
 *
 */
public class ConnectionManager {
	
	public static ThreadLocal<Connection> connectionHolder=new ThreadLocal<Connection>();
	/**
	 * �õ�Connection
	 * @return
	 */
	public static Connection getConnection(){
		
		Connection conn=connectionHolder.get();
		if(conn==null){
			try {
				JdbcConfig jdbcConfig=XmlConfigReader.getInstance().getJdbcConfig();
				Class.forName(jdbcConfig.getDriverName());
				conn=DriverManager.getConnection(jdbcConfig.getUrl(),jdbcConfig.getUserName(),jdbcConfig.getPassword());
				//��conn���õ���ǰThreadLocal����ֹ���̶߳�����ͬһ������
				connectionHolder.set(conn);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new ApplicationException("ϵͳ��������ϵϵͳ����Ա");
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ApplicationException("ϵͳ��������ϵϵͳ����Ա");
			}
		}
		return conn;
	}
	public static void closeConnection(){
		Connection conn=connectionHolder.get();
		if(conn!=null){
			try{
				conn.close();
				//��ThreadLocal�����Connection
				connectionHolder.remove();
			}catch(SQLException e){
				e.printStackTrace();
			}
			
		}
	}
	
	/**
	 * ֹͣ�Զ��ύ
	 * @param conn
	 */
	public static void beginTransaction(Connection conn){
		if(conn!=null){
			try {
				if(conn.getAutoCommit()){
					conn.setAutoCommit(false);//�ֶ��ύ
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * �ֶ��ύ����
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
	 * �ع�����
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
	 * �ָ���ԭ��״̬
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
