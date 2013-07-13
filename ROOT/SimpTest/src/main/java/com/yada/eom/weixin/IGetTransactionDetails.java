package com.yada.eom.weixin;

import com.yada.eom.weixin.model.TransInfoDetails;

/**
 * 《微信渠道EOM接口说明》 V1.0 中1.4交易明细查询
 * 
 * @author jiangfengming
 * 
 */
public interface IGetTransactionDetails {
	/**
	 * 
	 * @param accNo
	 * @param CurrencyType
	 * @param startDate
	 * @param endDate
	 * @param IsSelectMC
	 * @param tranType
	 * @param startCount
	 * @param endCount
	 * @param minAmt
	 * @param maxAmt
	 * @return
	 */
	public TransInfoDetails get(String accNo, String CurrencyType, String startDate, String endDate, String IsSelectMC,
			String tranType, String startCount, String endCount, String minAmt, String maxAmt);
}
