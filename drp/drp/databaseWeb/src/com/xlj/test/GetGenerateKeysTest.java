package com.xlj.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class GetGenerateKeysTest {

	public static void main(String[] args) throws SQLException{
		new Driver();//ע������
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/databaseWeb","root","Asdf-12345");
			stmt=conn.createStatement();
			stmt.executeUpdate("insert into tb_person " +
					" (user_name,english_name,age,sex,birthday,description)" +
					" values ('Name','English Name','17','nan',current_date(),'')");
			rs=stmt.getGeneratedKeys();//��ȡ�Զ����ɵļ�ֵ
			rs.next();
			System.out.println("id:"+rs.getInt(1));//�����һ��
		}finally{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}
	}
}
