package com.yada.eom.weixin.impl;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

import com.yada.eom.exception.EOMFailtureException;
import com.yada.eom.order.IEomHandle;
import com.yada.eom.weixin.IGetAccountMainKey;
import com.yada.eom.weixin.model.AccountAttributeInfo;

public class GetAccountMainKey implements IGetAccountMainKey {

	private IEomHandle cq008134;
	private String sessionId;

	public GetAccountMainKey(String sessionId, IEomHandle cq008134) {
		this.sessionId = sessionId;
		this.cq008134 = cq008134;
	}

	@Override
	public List<AccountAttributeInfo> get(String accNo) throws EOMFailtureException {
		ArrayList<AccountAttributeInfo> arrayList = new ArrayList<AccountAttributeInfo>();
		Document receDoc = cq008134.handle(sessionId, accNo);
		XPathFactory xPathFactory = XPathFactory.instance();
		XPathExpression<Object> expression = xPathFactory.compile("/Conversation/Message/RepeatGroup/GroupItem");
		List<Object> groupItems = expression.evaluate(receDoc);
		for (int i = 0; i < groupItems.size(); i++) {
			AccountAttributeInfo accountAttributeInfo = new AccountAttributeInfo();
			expression = xPathFactory.compile("Entity/Field[@FieldName='id']");
			Element id = (Element) expression.evaluate(groupItems.get(i)).get(0);
			accountAttributeInfo.setId(id.getAttributeValue("FieldValue"));
			expression = xPathFactory.compile("Entity/Field[@FieldName='accountRefNo']");
			Element accountRefNo = (Element) expression.evaluate(groupItems.get(i)).get(0);
			accountAttributeInfo.setAccountRefNo(accountRefNo.getAttributeValue("FieldValue"));
			expression = xPathFactory.compile("Entity/Field[@FieldName='currencyCode']");
			Element currencyCode = (Element) expression.evaluate(groupItems.get(i)).get(0);
			accountAttributeInfo.setCurrencyCode(currencyCode.getAttributeValue("FieldValue"));
			arrayList.add(accountAttributeInfo);
		}
		return arrayList;
	}

}
