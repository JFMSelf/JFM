package com.yada.eom.weixin.model;

public class BillDetails {
	private String statementDate;
	private String openingBalance;
	private String totalDebits;
	private String totalCredits;
	private String closingBalance;
	private String closingMinPayment;
	private String closingPastDueAmt;
	private String closingOverlimitAmt;
	private String closingTotalAmtDue;
	private String paymentDueDate;
	public String getStatementDate() {
		return statementDate;
	}
	public void setStatementDate(String statementDate) {
		this.statementDate = statementDate;
	}
	public String getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(String openingBalance) {
		this.openingBalance = openingBalance;
	}
	public String getTotalDebits() {
		return totalDebits;
	}
	public void setTotalDebits(String totalDebits) {
		this.totalDebits = totalDebits;
	}
	public String getTotalCredits() {
		return totalCredits;
	}
	public void setTotalCredits(String totalCredits) {
		this.totalCredits = totalCredits;
	}
	public String getClosingBalance() {
		return closingBalance;
	}
	public void setClosingBalance(String closingBalance) {
		this.closingBalance = closingBalance;
	}
	public String getClosingMinPayment() {
		return closingMinPayment;
	}
	public void setClosingMinPayment(String closingMinPayment) {
		this.closingMinPayment = closingMinPayment;
	}
	public String getClosingPastDueAmt() {
		return closingPastDueAmt;
	}
	public void setClosingPastDueAmt(String closingPastDueAmt) {
		this.closingPastDueAmt = closingPastDueAmt;
	}
	public String getClosingOverlimitAmt() {
		return closingOverlimitAmt;
	}
	public void setClosingOverlimitAmt(String closingOverlimitAmt) {
		this.closingOverlimitAmt = closingOverlimitAmt;
	}
	public String getClosingTotalAmtDue() {
		return closingTotalAmtDue;
	}
	public void setClosingTotalAmtDue(String closingTotalAmtDue) {
		this.closingTotalAmtDue = closingTotalAmtDue;
	}
	public String getPaymentDueDate() {
		return paymentDueDate;
	}
	public void setPaymentDueDate(String paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}
}
