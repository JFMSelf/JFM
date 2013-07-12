package com.yada.eom.weixin.impl;

import org.jdom2.Document;
import org.jdom2.Element;

import com.yada.eom.order.IEomHandle;
import com.yada.eom.order.ReceXmlField;
import com.yada.eom.weixin.IGetMobileNo;


public class GetMobileNo implements IGetMobileNo {

	private String sessionId;
	private IEomHandle cq016080;

	public GetMobileNo(String sessionId, IEomHandle cq016080) {
		this.sessionId = sessionId;
		this.cq016080 = cq016080;
	}

	@Override
	public String get(String accNo) {
		Document receDoc = cq016080.handle(sessionId, accNo);
		Element eMessage = receDoc.getRootElement().getChildren(ReceXmlField.Message).get(0);
		return eMessage.getChildren(ReceXmlField.Entity).get(1).getChild(ReceXmlField.Field)
				.getAttribute(ReceXmlField.FieldValue).getValue();
	}
}
