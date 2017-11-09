package com.bjpowernode.khfxxt;

public class Hjmx {

	//序号
	private int number;
	//日期
	private String date;
	//呼叫情况（有效通话，无效通话）
	private String hjqk;
	//客户
	private Khxx khxx;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHjqk() {
		return hjqk;
	}
	public void setHjqk(String hjqk) {
		this.hjqk = hjqk;
	}
	public Khxx getKhxx() {
		return khxx;
	}
	public void setKhxx(Khxx khxx) {
		this.khxx = khxx;
	}
	
}
