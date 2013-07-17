package com.yada.eom.core;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sema.eom.EOMException;
import com.sema.eom.SynchClientAdapter;
import com.yada.eom.exception.EOMFailtureException;

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

	public String send(String sendXmlMsg) throws EOMFailtureException {
		String eomDoConversation = null;
		try {
			eomDoConversation = clientAdapter.eomDoConversation(sendXmlMsg);
			logger.debug("EOM交互-------->" + System.getProperty("line.separator") + "发送数据----->"
					+ System.getProperty("line.separator") + sendXmlMsg + System.getProperty("line.separator")
					+ "收到数据----->" + System.getProperty("line.separator") + eomDoConversation);
			return eomDoConversation;
		} catch (EOMException e) {
			StringBuilder mess = new StringBuilder();
			mess.append("EOM交互失败: 发送数据----->");
			mess.append(System.getProperty("line.separator"));
			mess.append(sendXmlMsg);
			mess.append("收到数据----->");
			mess.append(System.getProperty("line.separator"));
			mess.append(eomDoConversation);
			logger.error(mess.toString(), e);
			throw new EOMFailtureException(e);
		}
	}
}
