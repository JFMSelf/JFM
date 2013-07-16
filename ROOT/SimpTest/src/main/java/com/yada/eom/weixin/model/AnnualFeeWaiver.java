package com.yada.eom.weixin.model;

public class AnnualFeeWaiver {
	//年费减免标志
	private String feeFlag;
	//年费免除开始时间
	private String feeStartDate;
	//年费免除结束时间
	private String feeEndDate;
	//下次年费日期
	private String nextFeeDate;
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
	public String getNextFeeDate() {
		return nextFeeDate;
	}
	public void setNextFeeDate(String nextFeeDate) {
		this.nextFeeDate = nextFeeDate;
	}
}
