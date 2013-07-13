package com.yada.eom.weixin.impl;

import org.jdom2.Document;

import com.yada.eom.order.IEomHandle;
import com.yada.eom.weixin.ICheckPin;

public class CheckPin implements ICheckPin {
	private String functionCode;
	private String channelName;
	private String sessionId;
	private IEomHandle cq016067;

	public CheckPin(String functionCode, String channelName, String sessionId, IEomHandle cq016067) {
		this.functionCode = functionCode;
		this.channelName = channelName;
		this.sessionId = sessionId;
		this.cq016067 = cq016067;
	}

	@Override
	public boolean verify(String accNo, String pin) {
		String[] parameters = new String[23];
		parameters[0] = sessionId;
		parameters[1] = channelName;
		parameters[3] = functionCode;
		parameters[19] = accNo;
		parameters[20] = pin;
		try {
			Document receDoc = cq016067.handle(parameters);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
