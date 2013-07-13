package com.yada.eom.weixin.impl;

import org.junit.Test;

import com.yada.eom.core.SynchEOMClient;
import com.yada.eom.order.impl.CQ045005_GR045003;

public class GetBillingSummaryTest {

	@Test
	public void testGet() {
		String path = GetAnnualFeeWaiverTest.class.getClassLoader().getResource("").getPath();
		path = path.replaceAll("test-classes", "classes");
		SynchEOMClient eomClient = new SynchEOMClient(path);
		CQ045005_GR045003 cq008003 = new CQ045005_GR045003(eomClient);
		GetBillingSummary getAnnualFeeWaiver = new GetBillingSummary("1", cq008003);
		getAnnualFeeWaiver.get("001A03F70055D4C8");
	}
}
