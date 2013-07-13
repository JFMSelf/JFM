package com.yada.eom.order;

import org.jdom2.Document;

public interface IEomHandle {
	/**
	 * 对信息打包发送然后返回dom
	 * 
	 * @param parameters
	 *            参数数量需要大于1，第一个参数必须是sessionId；
	 * @return JDOM2对象
	 */
	public Document handle(String... parameters) throws Exception;

}
