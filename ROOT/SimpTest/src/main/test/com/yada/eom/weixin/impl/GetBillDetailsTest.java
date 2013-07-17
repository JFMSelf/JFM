package com.yada.eom.weixin.impl;

import org.junit.Test;

import com.yada.eom.core.SynchEOMClient;
import com.yada.eom.exception.EOMFailtureException;
import com.yada.eom.order.impl.GQ045004_GR045004;

public class GetBillDetailsTest {

	@Test
	public void testGet() {
		String path = GetAnnualFeeWaiverTest.class.getClassLoader().getResource("").getPath();
		path = path.replaceAll("test-classes", "classes");
		SynchEOMClient eomClient = new SynchEOMClient(path);
		GQ045004_GR045004 cq008003 = new GQ045004_GR045004(eomClient);
		GetBillDetails getBillDetails = new GetBillDetails("1", cq008003);
		try {
			getBillDetails.get("001A03F70055D4C8","4");
		} catch (EOMFailtureException e) {
			e.printStackTrace();
		}
	}
}
