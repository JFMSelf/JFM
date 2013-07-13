package com.yada.eom.weixin.impl;

import org.junit.Test;

import com.yada.eom.core.SynchEOMClient;
import com.yada.eom.order.impl.CQ008134_CR008134;

public class GetAccountMainKeyTest {

	@Test
	public void testGet() {
		String path = GetAnnualFeeWaiverTest.class.getClassLoader().getResource("").getPath();
		path = path.replaceAll("test-classes", "classes");
		SynchEOMClient eomClient = new SynchEOMClient(path);
		CQ008134_CR008134 cq008134 = new CQ008134_CR008134(eomClient);
		GetAccountMainKey getAccountMainKey = new GetAccountMainKey("1", cq008134);
		getAccountMainKey.get("5149587707356843");
	}

}
