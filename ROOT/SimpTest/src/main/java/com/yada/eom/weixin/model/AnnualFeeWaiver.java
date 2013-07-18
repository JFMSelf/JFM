package com.yada.eom.weixin.model;

public class AnnualFeeWaiver {
	// 年费减免标志
	private String waiveMembershipFee;
	// 年费免除开始时间
	private String waiveMembershipFeeStartDate;
	// 年费免除结束时间
	private String waiveMembershipFeeEndDate;
	// 下次年费日期
	private String nextMembershipFeeDate;

	public String getNextMembershipFeeDate() {
		return nextMembershipFeeDate;
	}

	public void setNextMembershipFeeDate(String nextMembershipFeeDate) {
		this.nextMembershipFeeDate = nextMembershipFeeDate;
	}

	public String getWaiveMembershipFeeEndDate() {
		return waiveMembershipFeeEndDate;
	}

	public void setWaiveMembershipFeeEndDate(String waiveMembershipFeeEndDate) {
		this.waiveMembershipFeeEndDate = waiveMembershipFeeEndDate;
	}

	public String getWaiveMembershipFee() {
		return waiveMembershipFee;
	}

	public void setWaiveMembershipFee(String waiveMembershipFee) {
		this.waiveMembershipFee = waiveMembershipFee;
	}

	public String getWaiveMembershipFeeStartDate() {
		return waiveMembershipFeeStartDate;
	}

	public void setWaiveMembershipFeeStartDate(String waiveMembershipFeeStartDate) {
		this.waiveMembershipFeeStartDate = waiveMembershipFeeStartDate;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("AnnualFeeWaiver [waiveMembershipFee=");
		sb.append(waiveMembershipFee);
		sb.append(", waiveMembershipFeeStartDate=");
		sb.append(waiveMembershipFeeStartDate);
		sb.append(", waiveMembershipFeeEndDate=");
		sb.append(waiveMembershipFeeEndDate);
		sb.append(", nextMembershipFeeDate=");
		sb.append(nextMembershipFeeDate);
		sb.append("]");
		return sb.toString();
	}
}
