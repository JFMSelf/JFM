package com.yada.eom.weixin.model;

public class AnnualFeeWaiver {
	private String feeFlag;
	private String feeStartDate;
	private String feeEndDate;
	private String feeDate;
	public String getFeeFlag() {
		return feeFlag;
	}
	public void setFeeFlag(String feeFlag) {
		this.feeFlag = feeFlag;
	}
	public String getFeeStartDate() {
		return feeStartDate;
	}
	public void setFeeStartDate(String feeStartDate) {
		this.feeStartDate = feeStartDate;
	}
	public String getFeeEndDate() {
		return feeEndDate;
	}
	public void setFeeEndDate(String feeEndDate) {
		this.feeEndDate = feeEndDate;
	}
	public String getFeeDate() {
		return feeDate;
	}
	public void setFeeDate(String feeDate) {
		this.feeDate = feeDate;
	}
}
