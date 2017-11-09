package com.bjpowernode.hibernate;

import java.util.Date;

public class FiscalYearPeriod {
	
	private FiscalYearPeriodPK fisCalYearPeriodPK;
	private Date beginDate;
	private Date endDate;
	private String periodSts;
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
	public FiscalYearPeriodPK getFisCalYearPeriodPK() {
		return fisCalYearPeriodPK;
	}
	public void setFisCalYearPeriodPK(FiscalYearPeriodPK fisCalYearPeriodPK) {
		this.fisCalYearPeriodPK = fisCalYearPeriodPK;
	}
	public String getPeriodSts() {
		return periodSts;
	}
	public void setPeriodSts(String periodSts) {
		this.periodSts = periodSts;
	}
	
}
