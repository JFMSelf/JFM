package com.yada.eom.weixin.impl;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;

import com.yada.eom.core.SynchEOMClient;
import com.yada.eom.order.IEomHandle;
import com.yada.eom.order.ReceXmlField;
import com.yada.eom.order.impl.CQ045005_GR045003;
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
	public List<BillingSummary> get(String accountId) {
		
		try {
			Document receDoc = cq045005.handle(sessionId, accountId);
			
			List<Element> elementList=receDoc.getRootElement().getChildren("Message").get(0).getChildren("RepeatGroup").get(0).getChildren("GroupItem");
			if(elementList!=null&&elementList.size()!=0)
			{
				//创建账单摘要集合
				List<BillingSummary> billingSummaryList=new ArrayList<BillingSummary>();
				//遍历
				for(Element element:elementList)
				{
					List<Element> FieldList=element.getChildren("Entity").get(0).getChildren("Field");
					if(FieldList!=null&&FieldList.size()!=0)
					{
						//账单摘要实体
						BillingSummary billingSummary=new BillingSummary();
						//遍历Field
						for(int i=0;i<FieldList.size();i++)
						{
							Element fieldElement=FieldList.get(i);
							String fieldName=fieldElement.getAttribute("FieldName").getValue();
							
							if(fieldName.equals("statementDate"))
							{
								billingSummary.setDate(fieldElement.getAttribute("FieldValue").getValue());
							}else if(fieldName.equals("statementNo"))
							{
								billingSummary.setNumber(fieldElement.getAttribute("FieldValue").getValue());
							}
							
							
						}
						billingSummaryList.add(billingSummary);
					}
				}
				return billingSummaryList;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
}
