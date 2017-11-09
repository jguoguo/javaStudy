package com.xlj.spring.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class PersonDaoImpl extends JdbcDaoSupport implements IPersonDao {

	public void initDatabase(){//初始化方法，创建表
		String sql=" create table if not exists tb_person"
				+" (id int auto_increment,"+" name varchar(255), "
				+" sex varchar(10), age int ,birthday timestamp,primary key(id))";
		getJdbcTemplate().execute(sql);//执行sql
	}
	@Override
	public String getPersonName(Integer id) {
		String sql="select name from tb_person where id="+id;
		return (String)getJdbcTemplate().queryForObject(sql, String.class);
	}

	@Override
	public void addPerson(Person person) {
		String sql="insert into tb_person(name,sex,age,birthday) values(?,?,?,?)";
		getJdbcTemplate().update(sql,new Object[]{person.getName(),person.getSex(),person.getAge(),person.getBirthday()});
	}

	@Override
	public int getPersonsCount() {
		String sql="select count(*) from tb_person";
		return getJdbcTemplate().queryForInt(sql);
	}

	@SuppressWarnings("all")
	public List<Person> listPersons() {
		String sql="select id,name,sex,age,birthday from tb_person";
		List<Map<String,Object>> list=getJdbcTemplate().queryForList(sql);//返回数据
		List<Person> personList=new ArrayList<Person>();//List<Person>对象
		for(Map<String,Object>row:list){//遍历数据
			Person person=new Person();
			person.setId((Integer)row.get("id"));//设置Id
			person.setName((String)row.get("name"));//设置name
			person.setSex((String)row.get("sex"));//设置sex
			person.setAge((Integer)row.get("age"));//设置age
			person.setBirthday((Date)row.get("birthday"));//设置birthday
			personList.add(person);//添加到list
		}
		return personList;//返回list
	}
	
	public List findAllPersons(){
		PersonMappingQuery personQuery=new PersonMappingQuery();//使用封装查询
		personQuery.setDataSource(getDataSource());//设置数据源
		personQuery.setSql("select * from tb_person");//设置SQL
		personQuery.compile();//遍历sql
		return personQuery.execute(new Object[]{});//直接封装后的List
	}

}
