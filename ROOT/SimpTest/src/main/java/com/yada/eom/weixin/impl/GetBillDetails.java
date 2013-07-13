package com.yada.eom.weixin.impl;

import org.jdom2.Document;

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
	public BillDetails get(String accountId, String billNo) {
		try {
			Document receDoc = gq045004.handle(sessionId,accountId,billNo);
			//TODO 需要处理
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
