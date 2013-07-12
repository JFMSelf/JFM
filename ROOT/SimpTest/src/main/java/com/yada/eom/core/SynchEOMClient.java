package com.yada.eom.core;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sema.eom.SynchClientAdapter;

public class SynchEOMClient {
	private final static Logger logger = LoggerFactory.getLogger(SynchEOMClient.class);

	private final SynchClientAdapter clientAdapter;

	public SynchEOMClient() {
		this(null);
	}

	public SynchEOMClient(String caIniPath) {
		if (caIniPath == null || caIniPath.trim().isEmpty()) {
			caIniPath = SynchEOMClient.class.getClassLoader().getResource("").toString();
		}
		URI uri = null;
		try {
			uri = new URI(caIniPath);
		} catch (URISyntaxException e) {
			throw new RuntimeException("初始化SynchEOMClient错误。ca.ini路径[" + caIniPath + "]");
		}
		clientAdapter = new SynchClientAdapter(uri.getPath());
	}

	public String send(String sendXmlMsg) throws RuntimeException {
		String eomDoConversation = null;
		try {
			eomDoConversation = clientAdapter.eomDoConversation(sendXmlMsg);
			logger.debug("EOM交互-------->" + System.getProperty("line.separator") + "发送数据----->"
					+ System.getProperty("line.separator") + sendXmlMsg + System.getProperty("line.separator")
					+ "收到数据----->" + System.getProperty("line.separator") + eomDoConversation);
			return eomDoConversation;
		} catch (Exception e) {
			StringBuilder mess = new StringBuilder();
			mess.append("EOM交互失败: 发送数据[").append(sendXmlMsg).append("收到数据[");
			mess.append(eomDoConversation).append("]");
			throw new RuntimeException(mess.toString(), e);
		}
	}
}
