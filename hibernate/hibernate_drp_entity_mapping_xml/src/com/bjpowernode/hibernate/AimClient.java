package com.bjpowernode.hibernate;


/**
 * �跽�ͻ�
 * @author Administrator
 *
 */
public class AimClient {
	
	//����
	private int id;
	
	//�ն˻�����̵Ĵ���
	private String temiOrClientId;
	
	//����
	private String name;
	
	//����ID 
	private String levelId;
	
	//��������
	private String levelName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevelId() {
		return levelId;
	}

	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTemiOrClientId() {
		return temiOrClientId;
	}

	public void setTemiOrClientId(String temiOrClientId) {
		this.temiOrClientId = temiOrClientId;
	}
	
}
