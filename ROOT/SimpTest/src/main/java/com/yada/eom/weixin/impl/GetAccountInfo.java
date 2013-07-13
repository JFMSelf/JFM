package com.yada.eom.weixin.impl;

import org.jdom2.Document;

import com.yada.eom.order.IEomHandle;
import com.yada.eom.weixin.IGetAccountInfo;
import com.yada.eom.weixin.model.AccountInfo;

public class GetAccountInfo implements IGetAccountInfo {
	private IEomHandle cq016061;
	private String sessionId;

	public GetAccountInfo(String sessionId, IEomHandle cq016061) {
		this.sessionId = sessionId;
		this.cq016061 = cq016061;
	}

	@Override
	public AccountInfo get(String accNo, String currencyCode) {
		try {
			Document handle = cq016061.handle(sessionId, accNo, currencyCode);
			//TODO 需需要处理
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
