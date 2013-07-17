package com.yada.eom.weixin.model;

public class BillDetails {
	private String statementDate;// 对账单日期
	private String openingBalance;// 期初余额
	private String totalDebits;// 借记合计
	private String totalCredits;// 贷记合计
	private String closingBalance;// 期末余额
	private String closingMinPayment;// 周期最小还款
	private String closingPastDueAmt;// 欠款金额
	private String closingOverlimitAmt;// 超限金额
	private String closingTotalAmtDue;// 应付款总额
	private String paymentDueDate;// 到期还款日

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
