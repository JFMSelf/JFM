package com.yada.eom.weixin;

import com.yada.eom.weixin.model.AccountInfo;

/**
 * 
 * @author jiangfengming
 * 
 */
public interface IGetAccountInfo {
	public AccountInfo get(String accNo, String currencyCode);
}
