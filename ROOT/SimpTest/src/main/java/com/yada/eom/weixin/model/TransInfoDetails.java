package com.yada.eom.weixin.model;

public class TransInfoDetails {
	private String pan;// 卡号
	private String transactionDate;// 交易日期
	private String postingDate;// 记帐日期
	private String originalCurrencyCode;// 交易币种
	private String postingCurrencyCode;// 记帐币种
	private String originalTransactionAmount;// 交易金额
	private String postingAmount;// 记帐金额
	private String debitCreditCode;// 借方，贷方
	private String transactionProfileCode;// 交易代码
	private String transactionStatusCode;// 交易状态代码
	private String dateTxnDisputed;// 争议日期
	private String dateReleasedFromDispute;// 释放日期
	private String transactionDescription;// 交易描述

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}

	public String getOriginalCurrencyCode() {
		return originalCurrencyCode;
	}

	public void setOriginalCurrencyCode(String originalCurrencyCode) {
		this.originalCurrencyCode = originalCurrencyCode;
	}

	public String getPostingCurrencyCode() {
		return postingCurrencyCode;
	}

	public void setPostingCurrencyCode(String postingCurrencyCode) {
		this.postingCurrencyCode = postingCurrencyCode;
	}

	public String getOriginalTransactionAmount() {
		return originalTransactionAmount;
	}

	public void setOriginalTransactionAmount(String originalTransactionAmount) {
		this.originalTransactionAmount = originalTransactionAmount;
	}

	public String getPostingAmount() {
		return postingAmount;
	}

	public void setPostingAmount(String postingAmount) {
		this.postingAmount = postingAmount;
	}

	public String getDebitCreditCode() {
		return debitCreditCode;
	}

	public void setDebitCreditCode(String debitCreditCode) {
		this.debitCreditCode = debitCreditCode;
	}

	public String getTransactionProfileCode() {
		return transactionProfileCode;
	}

	public void setTransactionProfileCode(String transactionProfileCode) {
		this.transactionProfileCode = transactionProfileCode;
	}

	public String getTransactionStatusCode() {
		return transactionStatusCode;
	}

	public void setTransactionStatusCode(String transactionStatusCode) {
		this.transactionStatusCode = transactionStatusCode;
	}

	public String getDateTxnDisputed() {
		return dateTxnDisputed;
	}

	public void setDateTxnDisputed(String dateTxnDisputed) {
		this.dateTxnDisputed = dateTxnDisputed;
	}

	public String getDateReleasedFromDispute() {
		return dateReleasedFromDispute;
	}

	public void setDateReleasedFromDispute(String dateReleasedFromDispute) {
		this.dateReleasedFromDispute = dateReleasedFromDispute;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	@Override
	public String toString() {
		return "TransInfoDetails [pan=" + pan + ", transactionDate=" + transactionDate + ", postingDate=" + postingDate
				+ ", originalCurrencyCode=" + originalCurrencyCode + ", postingCurrencyCode=" + postingCurrencyCode
				+ ", originalTransactionAmount=" + originalTransactionAmount + ", postingAmount=" + postingAmount
				+ ", debitCreditCode=" + debitCreditCode + ", transactionProfileCode=" + transactionProfileCode
				+ ", transactionStatusCode=" + transactionStatusCode + ", dateTxnDisputed=" + dateTxnDisputed
				+ ", dateReleasedFromDispute=" + dateReleasedFromDispute + ", transactionDescription="
				+ transactionDescription + "]";
	}

}
