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
			throw new RuntimeException("��ʼ��SynchEOMClient����ca.ini·��[" + caIniPath + "]");
		}
		clientAdapter = new SynchClientAdapter(uri.getPath());
	}

	public String send(String sendXmlMsg) throws RuntimeException {
		String eomDoConversation = null;
		try {
			eomDoConversation = clientAdapter.eomDoConversation(sendXmlMsg);
			logger.debug("EOM����-------->" + System.getProperty("line.separator") + "��������----->"
					+ System.getProperty("line.separator") + sendXmlMsg + System.getProperty("line.separator")
					+ "�յ�����----->" + System.getProperty("line.separator") + eomDoConversation);
			return eomDoConversation;
		} catch (Exception e) {
			StringBuilder mess = new StringBuilder();
			mess.append("EOM����ʧ��: ��������[").append(sendXmlMsg).append("�յ�����[");
			mess.append(eomDoConversation).append("]");
			throw new RuntimeException(mess.toString(), e);
		}
	}
}
