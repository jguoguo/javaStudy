package com.bjpowernode.drp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBUtil {
	public static Connection getConn(){
		Connection conn=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/drp?user=root&password=Asdf-12345");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeConn(Connection conn){
		try{
			if(conn!=null){
				conn.close();
				conn=null;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void closeStmt(Statement stmt){
		try{
			if(stmt!=null){
				stmt.close();
				stmt=null;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void closeRs(ResultSet rs){
		try{
			if(rs!=null){
				rs.close();
				rs=null;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
