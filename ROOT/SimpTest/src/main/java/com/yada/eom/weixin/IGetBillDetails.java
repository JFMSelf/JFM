package com.yada.eom.weixin;

import com.yada.eom.weixin.model.BillDetails;

/**
 * 获取账单明细接口
 * 
 * @author jiangfengming
 * 
 */
public interface IGetBillDetails {
	/**
	 * 
	 * @param accountId 卡对应帐号ID
	 * @param billNo 对帐单序号
	 * @return
	 */
	public BillDetails get(String accountId, String billNo);
}
