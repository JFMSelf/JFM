package com.yada.eom.weixin;

import java.util.List;

import com.yada.eom.weixin.model.BillingSummary;

public interface IGetBillingSummary {
	public List<BillingSummary> get(String accountId);
}
