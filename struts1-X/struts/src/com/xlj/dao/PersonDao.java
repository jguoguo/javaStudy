package com.xlj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.xlj.bean.Person;
import com.xlj.bean.PersonList;

public class PersonDao {

	/**
	 * 添加用户
	 * @param conn
	 * @param person
	 * @throws Exception 
	 */
	public void addPerson(Connection conn,Person person) throws Exception{
		String personSql="insert into tb_person (account,name,birthday,secret,create_date)"
				+" values (?,?,?,?,?)";
		String hobbySql="insert into tb_hobby (person_id,hobby) values (?,?)";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn.setAutoCommit(false);//设置自动提交为false
			pstmt=conn.prepareStatement(personSql);
			pstmt.setString(1, person.getAccount());
			pstmt.setString(2, person.getName());
			pstmt.setDate(3, person.getBirthday());
			pstmt.setBoolean(4, person.isSecret());
			pstmt.setTimestamp(5, person.getCreateDate());
			pstmt.executeUpdate();
			rs=pstmt.getGeneratedKeys();//获取自动插入的ID值
			rs.next();
			int personId=rs.getInt(1);//获取第一条数据
			pstmt=conn.prepareStatement(hobbySql);
			for(Iterator<String> iter=person.getHobby().iterator();iter.hasNext();){
				pstmt.setInt(1, personId);
				pstmt.setString(2, iter.next());
				pstmt.addBatch();//添加批量执行
			}
			pstmt.executeBatch();//批量执行
			conn.commit();//提交事务
		}finally{
			if(rs!=null) rs.close();//关闭rs
			if(pstmt!=null) pstmt.close();//关闭pstmt
			if(conn!=null)conn.close();//关闭conn
		}
	}
	
	/**
	 * 显示所有用户
	 * @param conn
	 * @return
	 * @throws Exception 
	 */
	public List<Person> listPersons(Connection conn) throws Exception{
		String sql="select * from tb_person";
		List<Person> list=new ArrayList<Person>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Person person=new Person();
				person.setId(rs.getInt("id"));//设置Id
				person.setAccount(rs.getString("account"));
				person.setName(rs.getString("name"));
				person.setBirthday(rs.getDate("birthday"));
				person.setCreateDate(rs.getTimestamp("create_date"));
				person.setSecret(rs.getBoolean("secret"));
				list.add(person);
			}
			for(Iterator<Person> iter=list.iterator();iter.hasNext();){
				Person person=iter.next();
				rs=pstmt.executeQuery("select * from tb_hobby where person_id="+person.getId());
				while(rs.next()){
					person.getHobby().add(rs.getString("hobby"));
				}
			}
			
		}finally{
			if(rs!=null)rs.close();
			if(rs!=null)pstmt.close();
			if(rs!=null)conn.close();
		}
		return list;
	}
}
