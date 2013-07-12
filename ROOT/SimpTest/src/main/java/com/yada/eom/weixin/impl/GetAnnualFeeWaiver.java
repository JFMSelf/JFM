package com.yada.eom.weixin.impl;

import org.jdom2.Document;

import com.yada.eom.order.IEomHandle;
import com.yada.eom.weixin.IGetAnnualFeeWaiver;
import com.yada.eom.weixin.model.AnnualFeeWaiver;

public class GetAnnualFeeWaiver implements IGetAnnualFeeWaiver {
	private String sessionId;
	private IEomHandle cq008003;

	public GetAnnualFeeWaiver(String sessionId, IEomHandle cq008003) {
		this.sessionId = sessionId;
		this.cq008003 = cq008003;
	}

	@Override
	public AnnualFeeWaiver get(String accountId) {
		Document receDoc = cq008003.handle(sessionId, accountId);
		// TODO 进行处理封装
		return null;
	}
	
}
