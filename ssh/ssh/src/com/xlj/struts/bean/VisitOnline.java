package com.xlj.struts.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_visit_online")
public class VisitOnline {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	
	private String userId;
	private String ip;
	private String address;
	
	private boolean online;		//�Ƿ����ߣ�trueΪ�����ߣ�falseΪ������
	private String url;			//���ڷ��ʵ���ҳURL	
	private String title;		//���ڷ��ʵ���ҳ����
	
	private int screenWidth;	//��Ļ�ֱ��ʿ��
	private int screenHeight;	//��Ļ�ֱ��ʸ߶�
	private int colorDepth;		//��ɫλ��
	
	private String appName;		//������ں�
	private String userAgent;	//�����������ϵͳ����
	private String systemLanguage;//���������
	
	private int activeTimes;	//���ʴ���
	
	private Date startDate;		//��һ�η���ʱ��
	private Date lastActiveDate;//���һ�η���ʱ��
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public boolean isOnline() {
		return online;
	}
	public void setOnline(boolean online) {
		this.online = online;
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
	public int getActiveTimes() {
		return activeTimes;
	}
	public void setActiveTimes(int activeTimes) {
		this.activeTimes = activeTimes;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getLastActiveDate() {
		return lastActiveDate;
	}
	public void setLastActiveDate(Date lastActiveDate) {
		this.lastActiveDate = lastActiveDate;
	}
	
	
}
