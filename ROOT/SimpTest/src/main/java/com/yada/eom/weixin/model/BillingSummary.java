package com.yada.eom.weixin.model;

public class BillingSummary {
	// 对账单序号
	private String statementNo;
	// 对账单日期
	private String statementDate;
	
	public String getStatementNo() {
		return statementNo;
	}
	public void setStatementNo(String statementNo) {
		this.statementNo = statementNo;
	}
	public String getStatementDate() {
		return statementDate;
	}
	public void setStatementDate(String statementDate) {
		this.statementDate = statementDate;
	}

}
