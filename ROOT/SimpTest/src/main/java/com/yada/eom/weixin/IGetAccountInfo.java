package com.yada.eom.weixin;

import com.yada.eom.weixin.model.AccountInfo;

/**
 * 
 * @author jiangfengming
 * @param  accNo          卡号
 * @param  currencyCode   币种
 */
public interface IGetAccountInfo {
	public AccountInfo get(String accNo, String currencyCode);
}
