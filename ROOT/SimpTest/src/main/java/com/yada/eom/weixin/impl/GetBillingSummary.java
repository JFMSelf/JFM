package com.yada.eom.weixin.impl;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

import com.yada.eom.exception.EOMFailtureException;
import com.yada.eom.order.IEomHandle;
import com.yada.eom.weixin.IGetBillingSummary;
import com.yada.eom.weixin.model.BillingSummary;

public class GetBillingSummary implements IGetBillingSummary {
	private String sessionId;

	private IEomHandle cq045005;

	public GetBillingSummary(String sessionId, IEomHandle cq045005) {
		this.sessionId = sessionId;
		this.cq045005 = cq045005;
	}

	@Override
	public List<BillingSummary> get(String accountId) throws EOMFailtureException {
		List<BillingSummary> list = new ArrayList<BillingSummary>();
		Document receDoc = cq045005.handle(sessionId, accountId);
		XPathFactory xPathFactory = XPathFactory.instance();
		XPathExpression<Object> expression = xPathFactory.compile("/Conversation/Message/RepeatGroup/GroupItem");
		List<Object> groupItems = expression.evaluate(receDoc);
		for (int i = 0; i < groupItems.size(); i++) {
			Object o = groupItems.get(i);
			expression = xPathFactory.compile("Entity/Field[@FieldName='statementNo']");
			Element statementNo = (Element) expression.evaluate(o).get(0);
			BillingSummary b = new BillingSummary();
			b.setStatementNo(statementNo.getAttributeValue("FieldValue"));
			expression = xPathFactory.compile("Entity/Field[@FieldName='statementDate']");
			Element statementDate = (Element) expression.evaluate(o).get(0);
			b.setStatementDate(statementDate.getAttributeValue("FieldValue"));
			list.add(b);
		}

		return list;
	}

}
