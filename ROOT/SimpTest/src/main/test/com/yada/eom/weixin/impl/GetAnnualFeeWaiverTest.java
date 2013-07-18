package com.yada.eom.weixin.impl;

import org.junit.Test;

import com.yada.eom.core.SynchEOMClient;
import com.yada.eom.exception.EOMFailtureException;
import com.yada.eom.order.impl.CQ008003_CR008004;
import com.yada.eom.weixin.model.AnnualFeeWaiver;

public class GetAnnualFeeWaiverTest {
	@Test
	public void testGet() {
		String path = GetAnnualFeeWaiverTest.class.getClassLoader().getResource("").getPath();
		path = path.replaceAll("test-classes", "classes");
		SynchEOMClient eomClient = new SynchEOMClient(path);
		CQ008003_CR008004 cq008003 = new CQ008003_CR008004(eomClient);
		GetAnnualFeeWaiver getAnnualFeeWaiver = new GetAnnualFeeWaiver("1", cq008003);
		try {
			AnnualFeeWaiver annualFeeWaiver=getAnnualFeeWaiver.get("001A03F70055D4C8");
			System.out.println(annualFeeWaiver.toString());
		} catch (EOMFailtureException e) {
			e.printStackTrace();
		}
	}
}
