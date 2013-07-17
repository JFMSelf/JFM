package com.yada.eom.weixin.model;

public class AccountAttributeInfo {
	private String id;// 账户主键ID
	private String accountRefNo;// 账户号码
	private String currencyCode;// 币种

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountRefNo() {
		return accountRefNo;
	}

	public void setAccountRefNo(String accountRefNo) {
		this.accountRefNo = accountRefNo;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("AccountAttributeInfo [id=");
		sb.append(id);
		sb.append(", accountRefNo=");
		sb.append(accountRefNo);
		sb.append(", currencyCode=");
		sb.append(currencyCode);
		sb.append("]");
		return sb.toString();
	}

}
