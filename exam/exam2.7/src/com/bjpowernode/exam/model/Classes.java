package com.bjpowernode.exam.model;
/**
 * 
 * 班级实体类
 * */
public class Classes {
	//班级代码
	private int classesId;
	//班级名称
	private String classedName;
	//是否是叶子  1:是叶子，0:非叶子
	private int leaf;
	//父id
	private int pid;
	public int getClassesId() {
		return classesId;
	}
	public void setClassesId(int classesId) {
		this.classesId = classesId;
	}
	public String getClassedName() {
		return classedName;
	}
	public void setClassedName(String classedName) {
		this.classedName = classedName;
	}
	public int getLeaf() {
		return leaf;
	}
	public void setLeaf(int leaf) {
		this.leaf = leaf;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	
}
