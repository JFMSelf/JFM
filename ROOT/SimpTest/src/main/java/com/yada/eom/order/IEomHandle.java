package com.yada.eom.order;

import org.jdom2.Document;

public interface IEomHandle {
	/**
	 * ����Ϣ�������Ȼ�󷵻�dom
	 * 
	 * @param parameters
	 *            ����������Ҫ����1����һ������������sessionId��
	 * @return JDOM2����
	 */
	public Document handle(String... parameters) throws Exception;

}
