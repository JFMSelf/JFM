package com.yada.eom.weixin;

public interface ICheckPin {
	/**
	 * 《微信渠道EOM接口说明》v1.0中1.7 密码验证
	 * 
	 * @param accNo
	 *            卡号
	 * @param pin
	 * @return
	 */
	public boolean verify(String accNo, String pin);
}
