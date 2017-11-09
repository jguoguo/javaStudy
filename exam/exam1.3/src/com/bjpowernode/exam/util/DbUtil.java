package com.bjpowernode.exam.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 
 *��װ���ݿ���ز��� 
 * */
public class DbUtil {
	
	/**
	 * ȥ�����ݿ������
	 * @return  һ�����ݿ�����
	 * */
	public static Connection getConnection(){
		Connection conn=null;
		try{
			//��һ�����������ݿ���������ͬ�����ݿ����������ǲ�һ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//�ڶ������õ����ݿ�����
			String dbUrl="jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
			String userName="exam2";
			String password="exam2";
			conn=DriverManager.getConnection(dbUrl, userName, password);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	
	//�ر�PreparedStatement
	public static void close(PreparedStatement pstmt){
		if(pstmt!=null){
			try{
				pstmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	//�ر�connection
	public static void close(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args){
		
		Connection conn=DbUtil.getConnection();
		System.out.println(conn);
	}
}
