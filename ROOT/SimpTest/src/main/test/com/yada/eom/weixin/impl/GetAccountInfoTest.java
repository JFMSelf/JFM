package com.yada.eom.weixin.impl;

import org.junit.Test;

import com.yada.eom.core.SynchEOMClient;
import com.yada.eom.order.impl.CQ016061_CR016025;

public class GetAccountInfoTest {
	@Test
	public void testGet() {
		String path = GetAnnualFeeWaiverTest.class.getClassLoader().getResource("").getPath();
		path = path.replaceAll("test-classes", "classes");
		SynchEOMClient eomClient = new SynchEOMClient(path);
		CQ016061_CR016025 cq016061 = new CQ016061_CR016025(eomClient);
		GetAccountInfo getAccountInfo = new GetAccountInfo("1", cq016061);
		getAccountInfo.get("5149587707356843","156");
	}

}
