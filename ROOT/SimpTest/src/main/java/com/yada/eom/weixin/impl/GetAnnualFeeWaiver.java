package com.yada.eom.weixin.impl;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

import com.yada.eom.exception.EOMFailtureException;
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
	public AnnualFeeWaiver get(String accountId) throws EOMFailtureException {
		AnnualFeeWaiver annualFeeWaiver = new AnnualFeeWaiver();
		Document receDoc = cq008003.handle(sessionId, accountId);
		// 得到所有的Field
		XPathFactory xPathFactory = XPathFactory.instance();
		XPathExpression<Object> expression = null;
		// 下次年费日期
		expression = xPathFactory.compile("/Conversation/Message/Entity/Field[@FieldName='nextMembershipFeeDate']");
		Element nextMembershipFeeDate = (Element) expression.evaluate(receDoc).get(0);
		annualFeeWaiver.setNextMembershipFeeDate(nextMembershipFeeDate.getAttributeValue("FieldValue"));
		// 年费免除结束时间
		expression = xPathFactory.compile("/Conversation/Message/Entity/Field[@FieldName='waiveMembershipFeeEndDate']");
		Element waiveMembershipFeeEndDate = (Element) expression.evaluate(receDoc).get(0);
		annualFeeWaiver.setWaiveMembershipFeeEndDate(waiveMembershipFeeEndDate.getAttributeValue("FieldValue"));
		// 年费免除开始时间
		expression = xPathFactory.compile("/Conversation/Message/Entity/Field[@FieldName='waiveMembershipFee']");
		Element waiveMembershipFee = (Element) expression.evaluate(receDoc).get(0);
		annualFeeWaiver.setWaiveMembershipFee(waiveMembershipFee.getAttributeValue("FieldValue"));
		// 年费减免标志
		expression = xPathFactory
				.compile("/Conversation/Message/Entity/Field[@FieldName='waiveMembershipFeeStartDate']");
		Element waiveMembershipFeeStartDate = (Element) expression.evaluate(receDoc).get(0);
		annualFeeWaiver.setWaiveMembershipFeeStartDate(waiveMembershipFeeStartDate.getAttributeValue("FieldValue"));

		return annualFeeWaiver;
	}

}
