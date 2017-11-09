package com.xlj.spring.orm;

import java.util.List;

public interface ICatDao {
	public void createCat(Cat cat);//�������
	public List<Cat> listCats();//��ѯ���ж���
	public int getCatsCount();//���ض�������
	public Cat findCatByName(String name);//�������ֲ�ѯ����
}
