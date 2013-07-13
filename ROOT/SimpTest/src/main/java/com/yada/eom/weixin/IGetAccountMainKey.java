package com.yada.eom.weixin;

import java.util.List;

import com.yada.eom.weixin.model.AccountAttributeInfo;

/**
 * 获取账户主键。《微信渠道EOM接口说明 v1.0》中的1.1
 * 
 * @author jiangfengming
 * 
 */
public interface IGetAccountMainKey {
	public List<AccountAttributeInfo> get(String accNo);
}
