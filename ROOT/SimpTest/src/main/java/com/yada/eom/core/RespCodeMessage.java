package com.yada.eom.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RespCodeMessage {
	private static Logger logger = LoggerFactory.getLogger(RespCodeMessage.class);

	private static Map<String, String> messageMap;

	public static String getRespCodeMessage(String respCode) {
		if (messageMap == null) {
			initMap();
		}
		return messageMap.get(respCode);
	}

	private synchronized static void initMap() {
		if (messageMap == null) {
			messageMap = new HashMap<String, String>();
			InputStream in = null;
			BufferedReader reader = null;
			try {
				in = RespCodeMessage.class.getClassLoader().getResourceAsStream("RespCodeMessage.DAT");
				reader = new BufferedReader(new InputStreamReader(in));
				for (String temp = null; (temp = reader.readLine()) != null;) {
					if (temp.trim().equals("[ErrorMessages]")) {
						break;
					}
				}
				for (String temp = null; (temp = reader.readLine()) != null;) {
					String[] temps = temp.split(",");
					messageMap.put(temps[0], temps[1]);
				}

			} catch (IOException e) {
				logger.error("", e);
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
						logger.error("", e);
					}
				}
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						logger.error("", e);
					}
				}
			}
		}
	}
}
