package com.yada.eom.weixin.impl;

import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;

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
		try {
			Document receDoc = cq008003.handle(sessionId, accountId);
			//得到所有的Field
			List<Element> FieldList=receDoc.getRootElement().getChildren("Message").get(0).getChildren("Entity").get(0).getChildren("Field");
			if(FieldList!=null&&FieldList.size()!=0)
			{
				AnnualFeeWaiver annualFeeWaiver=new AnnualFeeWaiver();
				for(int i=0;i<FieldList.size();i++)
				{
					Element fieldElement=FieldList.get(i);
					String fieldName=fieldElement.getAttribute("FieldName").getValue();
					//取得具体字段
					if(fieldName.equals("nextMembershipFeeDate"))
					{
						annualFeeWaiver.setNextFeeDate(fieldElement.getAttribute("FieldValue").getValue());
					}else if(fieldName.equals("waiveMembershipFeeEndDate"))
					{
						annualFeeWaiver.setFeeEndDate(fieldElement.getAttribute("FieldValue").getValue());
					}else if(fieldName.equals("waiveMembershipFee"))
					{
						annualFeeWaiver.setFeeFlag(fieldElement.getAttribute("FieldValue").getValue());
					}else if(fieldName.equals("waiveMembershipFeeStartDate"))
					{
						annualFeeWaiver.setFeeStartDate(fieldElement.getAttribute("FieldValue").getValue());
					}
					
					
				}
				return annualFeeWaiver;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
