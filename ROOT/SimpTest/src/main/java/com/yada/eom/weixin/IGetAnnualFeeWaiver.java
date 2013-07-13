package com.yada.eom.weixin;

import com.yada.eom.weixin.model.AnnualFeeWaiver;

/**
 * 《微信渠道EOM接口说明》v1.0中1.6查询年费减免情况
 * 
 * @author jiangfengming
 * @param  accountId      卡主键
 */
public interface IGetAnnualFeeWaiver {
	public AnnualFeeWaiver get(String accountId);
}
