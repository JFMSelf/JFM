package com.yada.eom.weixin;

import com.yada.eom.weixin.model.BillDetails;

/**
 * 《微信渠道EOM接口说明》 1.0中的1.3查询账单明细
 * 
 * @author jiangfengming
 * 
 */
public interface IGetBillDetails {
	/**
	 * 
	 * @param accountId
	 *            账户主键ID
	 * @param billNo
	 *            对账单序号
	 * @return
	 */
	public BillDetails get(String accountId, String billNo);
}
