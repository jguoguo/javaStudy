package com.bjpowernode.hibernate;

import java.io.Serializable;
//必须实现序列化
public class FiscalYearPeriodPK implements Serializable {
	private int fiscalYear;
	private int fiscalPeriod;
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
	//通过工具生成，且必须覆盖hashCode和equals方法
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fiscalPeriod;
		result = prime * result + fiscalYear;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FiscalYearPeriodPK other = (FiscalYearPeriodPK) obj;
		if (fiscalPeriod != other.fiscalPeriod)
			return false;
		if (fiscalYear != other.fiscalYear)
			return false;
		return true;
	}
	
	
}
