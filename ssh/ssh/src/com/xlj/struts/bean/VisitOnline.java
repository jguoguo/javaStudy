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
	
	private boolean online;		//是否在线，true为仍在线，false为已离线
	private String url;			//正在访问的网页URL	
	private String title;		//正在访问的网页标题
	
	private int screenWidth;	//屏幕分辨率宽度
	private int screenHeight;	//屏幕分辨率高度
	private int colorDepth;		//颜色位数
	
	private String appName;		//浏览器内核
	private String userAgent;	//浏览器、操作系统详情
	private String systemLanguage;//浏览器语言
	
	private int activeTimes;	//访问次数
	
	private Date startDate;		//第一次访问时间
	private Date lastActiveDate;//最后一次访问时间
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
