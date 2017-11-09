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
 * 封装数据库常用操作
 * @author Administrator
 *
 */
public class DbUtil {
	/**
	 * 取得Connection
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
}
