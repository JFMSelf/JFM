package com.yada.eom.weixin.impl;

import java.util.List;

import org.jdom2.Document;

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
		Document receDoc = cq016081.handle(sessionId, accNo, CurrencyType, startDate, endDate, IsSelectMC, tranType,
				startCount, endCount, minAmt, maxAmt);
		// 返回文件多个时不确定这种解析是否正确。
		return null;
	}

}
