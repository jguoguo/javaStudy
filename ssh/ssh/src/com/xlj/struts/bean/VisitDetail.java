package com.xlj.struts.bean;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="tb_visit_detail")
public class VisitDetail {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;//id����
	
	private String ip;		//IP��ַ
	private String address;	//ʵ�ʵ�ַ
	private String url;		//��ҳURL	
	private String title;	//��ҳ����
	private String reffer;	//��ҳ��Դ��������������
	private String keyword;//������������棬��¼�ؼ���
	
	private int screenWidth;	//��Ļ�ֱ��ʿ��
	private int screenHeight;	//�߶�
	private int colorDepth;		//��ɫλ��
	
	private String appName;		//������ں�
	private String userAgent;	//�����������ϵͳ����
	private String systemLanguage;//���������
	private Date date;			//����ʱ��
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReffer() {
		return reffer;
	}
	public void setReffer(String reffer) {
		this.reffer = reffer;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getScreenWidth() {
		return screenWidth;
	}
	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}
	public int getScreenHeight() {
		return screenHeight;
	}
	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}
	public int getColorDepth() {
		return colorDepth;
	}
	public void setColorDepth(int colorDepth) {
		this.colorDepth = colorDepth;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public String getSystemLanguage() {
		return systemLanguage;
	}
	public void setSystemLanguage(String systemLanguage) {
		this.systemLanguage = systemLanguage;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
