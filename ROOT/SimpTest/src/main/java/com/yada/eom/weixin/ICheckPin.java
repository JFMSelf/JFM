package com.yada.eom.weixin;

public interface ICheckPin {
	/**
	 * ��֤����
	 * @param accNo �˺�
	 * @param pin ����
	 * @return
	 */
	public boolean verify(String accNo, String pin);
}
