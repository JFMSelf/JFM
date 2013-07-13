package com.yada.eom.weixin;

public interface ICheckPin {
	/**
	 * ÑéÖ¤ÃÜÂë
	 * @param accNo ÕËºÅ
	 * @param pin ÃÜÂë
	 * @return
	 */
	public boolean verify(String accNo, String pin);
}
