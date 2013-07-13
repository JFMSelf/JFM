package com.yada.eom.weixin.impl;

import org.junit.Test;

import com.yada.eom.core.SynchEOMClient;
import com.yada.eom.order.impl.CQ016081_CR016026;

public class GetTransactionDetailsTest  {
	@Test
	public void testGet() {
		String path = GetAnnualFeeWaiverTest.class.getClassLoader().getResource("").getPath();
		path = path.replaceAll("test-classes", "classes");
		SynchEOMClient eomClient = new SynchEOMClient(path);
		CQ016081_CR016026 cq016081 = new CQ016081_CR016026(eomClient);
		GetTransactionDetails getTransactionDetails = new GetTransactionDetails("1", cq016081);
		getTransactionDetails.get("5149587707356843", "156", "2000-01-01", "2013-07-13", "1", "ALLT", "1", "100", "0", "9999999999999");
	}
}
