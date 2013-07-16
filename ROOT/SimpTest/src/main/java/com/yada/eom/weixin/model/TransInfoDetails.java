package com.yada.eom.weixin.model;

public class TransInfoDetails {
	private String pan;
	private String transactionDate;
	private String postingDate;
	private String originalCurrencyCode;
	private String postingCurrencyCode;
	private String originalTxnAmount;
	private String postingAmount;
	private String txnProfCode;//借方，贷方
	private String txnCode;
	private String txnStatusCode;
	private String dateTransactionDisputed;
	private String DateReleasedFromDispute;
	private String txnDescription;
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
	public String getOriginalTxnAmount() {
		return originalTxnAmount;
	}
	public void setOriginalTxnAmount(String originalTxnAmount) {
		this.originalTxnAmount = originalTxnAmount;
	}
	public String getPostingAmount() {
		return postingAmount;
	}
	public void setPostingAmount(String postingAmount) {
		this.postingAmount = postingAmount;
	}
	public String getTxnProfCode() {
		return txnProfCode;
	}
	public void setTxnProfCode(String txnProfCode) {
		this.txnProfCode = txnProfCode;
	}
	public String getTxnCode() {
		return txnCode;
	}
	public void setTxnCode(String txnCode) {
		this.txnCode = txnCode;
	}
	public String getTxnStatusCode() {
		return txnStatusCode;
	}
	public void setTxnStatusCode(String txnStatusCode) {
		this.txnStatusCode = txnStatusCode;
	}
	public String getDateTransactionDisputed() {
		return dateTransactionDisputed;
	}
	public void setDateTransactionDisputed(String dateTransactionDisputed) {
		this.dateTransactionDisputed = dateTransactionDisputed;
	}
	public String getDateReleasedFromDispute() {
		return DateReleasedFromDispute;
	}
	public void setDateReleasedFromDispute(String dateReleasedFromDispute) {
		DateReleasedFromDispute = dateReleasedFromDispute;
	}
	public String getTxnDescription() {
		return txnDescription;
	}
	public void setTxnDescription(String txnDescription) {
		this.txnDescription = txnDescription;
	}
	
	
}
