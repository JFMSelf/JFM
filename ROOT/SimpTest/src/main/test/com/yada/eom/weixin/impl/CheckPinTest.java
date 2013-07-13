package com.yada.eom.weixin.impl;

import org.junit.Test;

import com.yada.eom.core.SynchEOMClient;
import com.yada.eom.order.impl.CQ016067_CR010011;
import com.yada.eom.util.CodecUtil;

public class CheckPinTest {

	@Test
	public void testVerify() {
		String path = GetAnnualFeeWaiverTest.class.getClassLoader().getResource("").getPath();
		path = path.replaceAll("test-classes", "classes");
		SynchEOMClient eomClient = new SynchEOMClient(path);
		CQ016067_CR010011 cq016067 = new CQ016067_CR010011(eomClient);
		CheckPin checkPin = new CheckPin("PINI", "YADA", "1", cq016067);
		byte[] tempPin = CodecUtil.pin2PinBlockWithCardNO("111111", "6227611144317177");
		checkPin.verify("6227611144317177", "11111111111111111111" + CodecUtil.hexEncode(tempPin));
	}
}
