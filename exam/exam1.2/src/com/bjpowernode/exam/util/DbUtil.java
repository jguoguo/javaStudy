package com.bjpowernode.exam.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 
 *封装数据库相关操作 
 * */
public class DbUtil {
	
	/**
	 * 去得数据库的链接
	 * @return  一个数据库链接
	 * */
	public static Connection getConnection(){
		Connection conn=null;
		try{
			//第一步：加载数据库驱动，不同的数据库驱动程序是不一样的
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//第二步：得到数据库连接
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
	
	//关闭PreparedStatement
	public static void close(PreparedStatement pstmt){
		if(pstmt!=null){
			try{
				pstmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	//关闭connection
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
