package com.yada.eom.weixin;

import java.util.List;

import com.yada.eom.exception.EOMFailtureException;
import com.yada.eom.weixin.model.BillingSummary;

/**
 * 《微信渠道EOM接口说明》中的1.2，查询账单摘要
 * 
 * @author jiangfengming
 * @parm accountId 卡主键
 * 
 */
public interface IGetBillingSummary {
	public List<BillingSummary> get(String accountId) throws EOMFailtureException;
}
