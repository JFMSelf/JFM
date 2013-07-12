package com.yada.eom.weixin;

/**
 * 获取手机号的接口
 * 
 * @author jiangfengming
 * 
 */
public interface IGetMobileNo {
	/**
	 * 通过卡号获取手机号
	 * 
	 * @param mobileNo
	 * @return
	 */
	public String get(String accNo);
}
