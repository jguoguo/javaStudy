package com.bjpowernode.drp.util;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ��װ���ݿⳣ�ò���
 * @author Administrator
 *
 */
public class DbUtil {
	/**
	 * ȡ��Connection
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn=null;
		JdbcConfig jdbcConfig;
		jdbcConfig=XmlConfigReader.getInstance().getJdbcConfig();
		try {
			Class.forName(jdbcConfig.getDriverName());
			conn=DriverManager.getConnection(jdbcConfig.getUrl(),jdbcConfig.getUserName(),jdbcConfig.getPassword());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
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
	public static void main(String[] args){
		System.out.println(DbUtil.getConnection());
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
}
