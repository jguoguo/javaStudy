package com.bjpowernode.drp.basedata.domain;

import java.util.Date;

public class FiscalYearPeriod {
	private int id;
	private int fiscalYear;
	private int fiscalPeriod;
	private Date beginDate;
	private Date endDate;
	private String periodSts;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFiscalYear() {
		return fiscalYear;
	}
	public void setFiscalYear(int fiscalYear) {
		this.fiscalYear = fiscalYear;
	}
	public int getFiscalPeriod() {
		return fiscalPeriod;
	}
	public void setFiscalPeriod(int fiscalPeriod) {
		this.fiscalPeriod = fiscalPeriod;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getPeriodSts() {
		return periodSts;
	}
	public void setPeriodSts(String periodSts) {
		this.periodSts = periodSts;
	}

	
}
