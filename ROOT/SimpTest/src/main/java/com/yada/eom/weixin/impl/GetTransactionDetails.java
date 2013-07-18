package com.yada.eom.weixin.impl;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

import com.yada.eom.exception.EOMFailtureException;
import com.yada.eom.order.IEomHandle;
import com.yada.eom.weixin.IGetTransactionDetails;
import com.yada.eom.weixin.model.TransInfoDetails;

public class GetTransactionDetails implements IGetTransactionDetails {
	private IEomHandle cq016081;
	private String sessionId;

	public GetTransactionDetails(String sessionId, IEomHandle cq016081) {
		this.sessionId = sessionId;
		this.cq016081 = cq016081;
	}

	@Override
	public List<TransInfoDetails> get(String accNo, String CurrencyType, String startDate, String endDate,
			String IsSelectMC, String tranType, String startCount, String endCount, String minAmt, String maxAmt)
			throws EOMFailtureException {
		List<TransInfoDetails> list = new ArrayList<TransInfoDetails>();
		Document receDoc = cq016081.handle(sessionId, accNo, CurrencyType, startDate, endDate, IsSelectMC, tranType,
				startCount, endCount, minAmt, maxAmt);

		XPathFactory xPathFactory = XPathFactory.instance();
		XPathExpression<Object> expression = xPathFactory.compile("/Conversation/Message/RepeatGroup/GroupItem");
		List<Object> groupItems = expression.evaluate(receDoc);
		for (int i = 0; i < groupItems.size(); i++) {
			TransInfoDetails details = new TransInfoDetails();
			Object o = groupItems.get(i);

			// 释放日期
			expression = xPathFactory.compile("Entity/Field[@FieldName='dateReleasedFromDispute']");
			Element dateReleasedFromDispute = (Element) expression.evaluate(o).get(0);
			details.setDateReleasedFromDispute(dateReleasedFromDispute.getAttributeValue("FieldValue"));

			// 争议日期
			expression = xPathFactory.compile("Entity/Field[@FieldName='dateTxnDisputed']");
			Element dateTxnDisputed = (Element) expression.evaluate(o).get(0);
			details.setDateTxnDisputed(dateTxnDisputed.getAttributeValue("FieldValue"));

			// 交易币种
			expression = xPathFactory.compile("Entity/Field[@FieldName='originalCurrencyCode']");
			Element originalCurrencyCode = (Element) expression.evaluate(o).get(0);
			details.setOriginalCurrencyCode(originalCurrencyCode.getAttributeValue("FieldValue"));

			// 交易金额
			expression = xPathFactory.compile("Entity/Field[@FieldName='originalTransactionAmount']");
			Element originalTransactionAmount = (Element) expression.evaluate(o).get(0);
			details.setOriginalTransactionAmount(originalTransactionAmount.getAttributeValue("FieldValue"));

			// 卡号
			expression = xPathFactory.compile("Entity/Field[@FieldName='pan']");
			Element pan = (Element) expression.evaluate(o).get(0);
			details.setPan(pan.getAttributeValue("FieldValue"));

			// 记帐金额
			expression = xPathFactory.compile("Entity/Field[@FieldName='postingAmount']");
			Element postingAmount = (Element) expression.evaluate(o).get(0);
			details.setPostingAmount(postingAmount.getAttributeValue("FieldValue"));

			// 记帐币种
			expression = xPathFactory.compile("Entity/Field[@FieldName='postingCurrencyCode']");
			Element postingCurrencyCode = (Element) expression.evaluate(o).get(0);
			details.setPostingCurrencyCode(postingCurrencyCode.getAttributeValue("FieldValue"));

			// 记帐日期
			expression = xPathFactory.compile("Entity/Field[@FieldName='postingDate']");
			Element postingDate = (Element) expression.evaluate(o).get(0);
			details.setPostingDate(postingDate.getAttributeValue("FieldValue"));

			// 交易日期
			expression = xPathFactory.compile("Entity/Field[@FieldName='transactionDate']");
			Element transactionDate = (Element) expression.evaluate(o).get(0);
			details.setTransactionDate(transactionDate.getAttributeValue("FieldValue"));

			// 交易代码
			expression = xPathFactory.compile("Entity/Field[@FieldName='transactionProfileCode']");
			Element transactionProfileCode = (Element) expression.evaluate(o).get(0);
			details.setTransactionProfileCode(transactionProfileCode.getAttributeValue("FieldValue"));

			// 交易描述
			expression = xPathFactory.compile("Entity/Field[@FieldName='transactionDescription']");
			Element transactionDescription = (Element) expression.evaluate(o).get(0);
			details.setTransactionDescription(transactionDescription.getAttributeValue("FieldValue"));

			// 借方，贷方
			expression = xPathFactory.compile("Entity/Field[@FieldName='debitCreditCode']");
			Element debitCreditCode = (Element) expression.evaluate(o).get(0);
			details.setDebitCreditCode(debitCreditCode.getAttributeValue("FieldValue"));

			// 交易状态代码
			expression = xPathFactory.compile("Entity/Field[@FieldName='transactionStatusCode']");
			Element transactionStatusCode = (Element) expression.evaluate(o).get(0);
			details.setTransactionStatusCode(transactionStatusCode.getAttributeValue("FieldValue"));

			list.add(details);
		}

		return list;
	}

}
