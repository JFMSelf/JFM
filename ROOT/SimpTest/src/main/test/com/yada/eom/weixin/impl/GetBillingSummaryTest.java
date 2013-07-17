package com.yada.eom.weixin.impl;

import java.util.List;

import org.junit.Test;

import com.yada.eom.core.SynchEOMClient;
import com.yada.eom.exception.EOMFailtureException;
import com.yada.eom.order.impl.CQ045005_GR045003;
import com.yada.eom.weixin.model.BillingSummary;

public class GetBillingSummaryTest {

	@Test
	public void testGet() throws EOMFailtureException {
		String path = GetAnnualFeeWaiverTest.class.getClassLoader().getResource("").getPath();
		path = path.replaceAll("test-classes", "classes");
		SynchEOMClient eomClient = new SynchEOMClient(path);
		CQ045005_GR045003 cq008003 = new CQ045005_GR045003(eomClient);
		GetBillingSummary getAnnualFeeWaiver = new GetBillingSummary("1", cq008003);
		List<BillingSummary> list = getAnnualFeeWaiver.get("001A03F70055D4C8");
		for (BillingSummary b : list) {
			System.out.println("账单日期：" + b.getStatementDate() + "    账单编号：" + b.getStatementNo());
		}
	}
}
