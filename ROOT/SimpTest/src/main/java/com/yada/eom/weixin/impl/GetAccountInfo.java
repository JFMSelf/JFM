package com.yada.eom.weixin.impl;

import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.junit.internal.builders.IgnoredBuilder;

import com.yada.eom.core.IgnoreDTDEntityResolver;
import com.yada.eom.order.IEomHandle;
import com.yada.eom.order.ReceXmlField;
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
			Document document = cq016061.handle(sessionId, accNo, currencyCode);
			SAXBuilder builder=new SAXBuilder();
			builder.setEntityResolver(new IgnoreDTDEntityResolver());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
