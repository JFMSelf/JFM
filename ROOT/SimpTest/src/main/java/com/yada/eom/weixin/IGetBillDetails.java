package com.yada.eom.weixin;

import com.yada.eom.weixin.model.BillDetails;

/**
 * ��ȡ�˵���ϸ�ӿ�
 * 
 * @author jiangfengming
 * 
 */
public interface IGetBillDetails {
	/**
	 * 
	 * @param accountId ����Ӧ�ʺ�ID
	 * @param billNo ���ʵ����
	 * @return
	 */
	public BillDetails get(String accountId, String billNo);
}
