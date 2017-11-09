package com.xlj.spring.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class PersonDaoImpl extends JdbcDaoSupport implements IPersonDao {

	public void initDatabase(){//��ʼ��������������
		String sql=" create table if not exists tb_person"
				+" (id int auto_increment,"+" name varchar(255), "
				+" sex varchar(10), age int ,birthday timestamp,primary key(id))";
		getJdbcTemplate().execute(sql);//ִ��sql
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
		List<Map<String,Object>> list=getJdbcTemplate().queryForList(sql);//��������
		List<Person> personList=new ArrayList<Person>();//List<Person>����
		for(Map<String,Object>row:list){//��������
			Person person=new Person();
			person.setId((Integer)row.get("id"));//����Id
			person.setName((String)row.get("name"));//����name
			person.setSex((String)row.get("sex"));//����sex
			person.setAge((Integer)row.get("age"));//����age
			person.setBirthday((Date)row.get("birthday"));//����birthday
			personList.add(person);//��ӵ�list
		}
		return personList;//����list
	}
	
	public List findAllPersons(){
		PersonMappingQuery personQuery=new PersonMappingQuery();//ʹ�÷�װ��ѯ
		personQuery.setDataSource(getDataSource());//��������Դ
		personQuery.setSql("select * from tb_person");//����SQL
		personQuery.compile();//����sql
		return personQuery.execute(new Object[]{});//ֱ�ӷ�װ���List
	}

}
