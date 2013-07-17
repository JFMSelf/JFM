package com.yada.eom.weixin.impl;

import java.util.List;

import org.junit.Test;

import com.yada.eom.core.SynchEOMClient;
import com.yada.eom.exception.EOMFailtureException;
import com.yada.eom.order.impl.CQ008134_CR008134;
import com.yada.eom.weixin.model.AccountAttributeInfo;

public class GetAccountMainKeyTest {

	@Test
	public void testGet() {
		String accNo = "6259062306725164";
		
		String path = GetAnnualFeeWaiverTest.class.getClassLoader().getResource("").getPath();
		path = path.replaceAll("test-classes", "classes");
		SynchEOMClient eomClient = new SynchEOMClient(path);
		CQ008134_CR008134 cq008134 = new CQ008134_CR008134(eomClient);
		GetAccountMainKey getAccountMainKey = new GetAccountMainKey("1", cq008134);
		try {
			List<AccountAttributeInfo> list = getAccountMainKey.get(accNo);
			for (AccountAttributeInfo i : list) {
				System.out.println(i.toString());
			}
		} catch (EOMFailtureException e) {
			e.printStackTrace();
		}
	}

}
