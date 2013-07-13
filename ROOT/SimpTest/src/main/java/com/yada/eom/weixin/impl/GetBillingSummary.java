package com.yada.eom.weixin.impl;

import java.util.List;

import org.jdom2.Document;

import com.yada.eom.core.SynchEOMClient;
import com.yada.eom.order.IEomHandle;
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
			// TODO 等待完成
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		SynchEOMClient eomClient = new SynchEOMClient();
		CQ045005_GR045003 a = new CQ045005_GR045003(eomClient);
		GetBillingSummary temp = new GetBillingSummary("1", a);
		temp.get("001A03F70055CB7A");
	}
}
