package com.yada.eom.weixin.impl;

import java.util.List;

import org.jdom2.Document;

import com.yada.eom.core.SynchEOMClient;
import com.yada.eom.order.IEomHandle;
import com.yada.eom.order.impl.CQ045005_GR045003;
import com.yada.eom.weixin.IGetBillingSummary;
import com.yada.eom.weixin.model.BillingSummary;

public class GetBillingSummaryImpl implements IGetBillingSummary {
	private String sessionId;

	private IEomHandle cq045005;

	public GetBillingSummaryImpl(String sessionId, IEomHandle cq045005) {
		this.sessionId = sessionId;
		this.cq045005 = cq045005;
	}

	@Override
	public List<BillingSummary> get(String accountId) {
		
		Document receDoc = cq045005.handle(sessionId, accountId);
		// TODO 读取receDoc转成对象
		
		return null;
	}
	
	public static void main(String[] args) {
		SynchEOMClient eomClient = new SynchEOMClient();
		CQ045005_GR045003 a = new CQ045005_GR045003(eomClient);
		GetBillingSummaryImpl temp = new GetBillingSummaryImpl("1", a);
		temp.get("001A03F70055CB7A");
	}
}
