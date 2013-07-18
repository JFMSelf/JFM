package com.yada.eom.weixin.impl;

import java.util.List;

import org.junit.Test;

import com.yada.eom.core.SynchEOMClient;
import com.yada.eom.exception.EOMFailtureException;
import com.yada.eom.order.impl.CQ016081_CR016026;
import com.yada.eom.weixin.model.TransInfoDetails;

public class GetTransactionDetailsTest {
	@Test
	public void testGet() {
		String path = GetAnnualFeeWaiverTest.class.getClassLoader().getResource("").getPath();
		path = path.replaceAll("test-classes", "classes");
		SynchEOMClient eomClient = new SynchEOMClient(path);
		CQ016081_CR016026 cq016081 = new CQ016081_CR016026(eomClient);
		GetTransactionDetails getTransactionDetails = new GetTransactionDetails("1", cq016081);
		try {
			List<TransInfoDetails> list = getTransactionDetails.get("5149587707356843", "", "2000-01-01", "2019-07-13",
					"1", "ALLT", "1", "100", "0", "9999999999999");
			for (TransInfoDetails t : list) {
				System.out.println(t.toString());
			}
		} catch (EOMFailtureException e) {
			e.printStackTrace();
		}
	}
}
