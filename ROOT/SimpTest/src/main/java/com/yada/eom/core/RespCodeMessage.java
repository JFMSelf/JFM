package com.yada.eom.core;

import java.util.HashMap;
import java.util.Map;

public class RespCodeMessage {
	private static Map<String, String> messageMap;

	public static String getRespCodeMessage(String respCode) {
		if (messageMap == null) {
			initMap();
		}
		return null;
	}

	private synchronized static void initMap() {
		if (messageMap == null) {
			messageMap = new HashMap<String, String>();
			// TODO 读取配置文件放入到MAP中。
		}
	}
}
