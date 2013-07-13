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
	 * @param accNo        卡号
	 * @param CurrencyType 币种类型
	 * @param startDate    查询开始时间
	 * @param endDate      查询结束时间
	 * @param IsSelectMC   是否查询主卡下的副卡
	 * @param tranType     交易类型
	 * @param startCount   开始条数
	 * @param endCount     选择的条数
	 * @param minAmt       金额（低值）
	 * @param maxAmt       金额（高值）
	 * @return
	 */
	public TransInfoDetails get(String accNo, String CurrencyType, String startDate, String endDate, String IsSelectMC,
			String tranType, String startCount, String endCount, String minAmt, String maxAmt);
}
