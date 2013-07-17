package com.yada.eom.order;

import org.jdom2.Document;

import com.yada.eom.exception.EOMFailtureException;

public interface IEomHandle {
	/**
	 * 组装XML发送并接收
	 * 
	 * @param parameters
	 *            参数，第一个参数必须为sessionId
	 * @return JDOM2的Document
	 */
	public Document handle(String... parameters) throws EOMFailtureException;

}
