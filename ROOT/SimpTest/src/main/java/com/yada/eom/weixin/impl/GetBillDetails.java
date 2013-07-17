package com.yada.eom.weixin.impl;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

import com.yada.eom.exception.EOMFailtureException;
import com.yada.eom.order.impl.GQ045004_GR045004;
import com.yada.eom.weixin.IGetBillDetails;
import com.yada.eom.weixin.model.BillDetails;

public class GetBillDetails implements IGetBillDetails {
	private String sessionId;
	private GQ045004_GR045004 gq045004;

	public GetBillDetails(String sessionId, GQ045004_GR045004 gq045004) {
		this.sessionId = sessionId;
		this.gq045004 = gq045004;
	}

	@Override
	public BillDetails get(String accountId, String billNo) throws EOMFailtureException {
		BillDetails billDetails = new BillDetails();
		Document receDoc = gq045004.handle(sessionId, accountId, billNo);
		XPathFactory xPathFactory = XPathFactory.instance();
		XPathExpression<Object> expression = xPathFactory
				.compile("/Conversation/Message/Entity/Field[@FieldName='statementDate']");
		Element statementDate = (Element) expression.evaluate(receDoc).get(0);
		billDetails.setStatementDate(statementDate.getAttributeValue("FieldValue"));
		expression = xPathFactory.compile("/Conversation/Message/Entity/Field[@FieldName='closingBalance']");
		Element closingBalance = (Element) expression.evaluate(receDoc).get(0);
		billDetails.setClosingBalance(closingBalance.getAttributeValue("FieldValue"));
		expression = xPathFactory.compile("/Conversation/Message/Entity/Field[@FieldName='closingMinPayment']");
		Element closingMinPayment = (Element) expression.evaluate(receDoc).get(0);
		billDetails.setClosingMinPayment(closingMinPayment.getAttributeValue("FieldValue"));
		expression = xPathFactory.compile("/Conversation/Message/Entity/Field[@FieldName='closingOverlimitAmt']");
		Element closingOverlimitAmt = (Element) expression.evaluate(receDoc).get(0);
		billDetails.setClosingOverlimitAmt(closingOverlimitAmt.getAttributeValue("FieldValue"));
		expression = xPathFactory.compile("/Conversation/Message/Entity/Field[@FieldName='closingPastDueAmt']");
		Element closingPastDueAmt = (Element) expression.evaluate(receDoc).get(0);
		billDetails.setClosingPastDueAmt(closingPastDueAmt.getAttributeValue("FieldValue"));
		expression = xPathFactory.compile("/Conversation/Message/Entity/Field[@FieldName='closingTotalAmtDue']");
		Element closingTotalAmtDue = (Element) expression.evaluate(receDoc).get(0);
		billDetails.setClosingTotalAmtDue(closingTotalAmtDue.getAttributeValue("FieldValue"));
		expression = xPathFactory.compile("/Conversation/Message/Entity/Field[@FieldName='openingBalance']");
		Element openingBalance = (Element) expression.evaluate(receDoc).get(0);
		billDetails.setOpeningBalance(openingBalance.getAttributeValue("FieldValue"));
		expression = xPathFactory.compile("/Conversation/Message/Entity/Field[@FieldName='paymentDueDate']");
		Element paymentDueDate = (Element) expression.evaluate(receDoc).get(0);
		billDetails.setPaymentDueDate(paymentDueDate.getAttributeValue("FieldValue"));
		expression = xPathFactory.compile("/Conversation/Message/Entity/Field[@FieldName='totalCredits']");
		Element totalCredits = (Element) expression.evaluate(receDoc).get(0);
		billDetails.setTotalCredits(totalCredits.getAttributeValue("FieldValue"));
		expression = xPathFactory.compile("/Conversation/Message/Entity/Field[@FieldName='totalDebits']");
		Element totalDebits = (Element) expression.evaluate(receDoc).get(0);
		billDetails.setTotalDebits(totalDebits.getAttributeValue("FieldValue"));

		expression.evaluate(receDoc);
		return null;
	}

}
