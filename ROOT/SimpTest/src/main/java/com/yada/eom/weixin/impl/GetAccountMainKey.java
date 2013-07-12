package com.yada.eom.weixin.impl;

import java.util.List;

import org.jdom2.Document;

import com.yada.eom.order.IEomHandle;
import com.yada.eom.weixin.IGetAccountMainKey;
import com.yada.eom.weixin.model.Accuont;

public class GetAccountMainKey implements IGetAccountMainKey {

	private IEomHandle cq008134;
	private String sessionId;

	public GetAccountMainKey(String sessionId, IEomHandle cq008134) {
		this.sessionId = sessionId;
		this.cq008134 = cq008134;
	}

	@Override
	public List<Accuont> get(String accNo) {
		Document receDoc = cq008134.handle(sessionId, accNo);
		// TODO ½âÎödocument

		return null;
	}
	
}
