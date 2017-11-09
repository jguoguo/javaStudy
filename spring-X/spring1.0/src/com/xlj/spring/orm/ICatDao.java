package com.xlj.spring.orm;

import java.util.List;

public interface ICatDao {
	public void createCat(Cat cat);//保存对象
	public List<Cat> listCats();//查询所有对象
	public int getCatsCount();//返回对象数量
	public Cat findCatByName(String name);//根据名字查询对象
}
