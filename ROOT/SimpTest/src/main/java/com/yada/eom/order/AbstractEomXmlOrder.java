package com.yada.eom.order;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.charset.Charset;

import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;

import com.yada.eom.core.IgnoreDTDEntityResolver;
import com.yada.eom.core.SynchEOMClient;


public abstract class AbstractEomXmlOrder implements IEomHandle{

	protected SynchEOMClient eomClient;
	protected String splitString = "\\$\\{dynamicValue\\}";
	protected String[] contents = null;
	protected String configPath;

	public AbstractEomXmlOrder(SynchEOMClient eomClient) {
		this.eomClient = eomClient;

		StringBuilder tempPath = new StringBuilder();
		tempPath.append("com/yada/eom/order/mapper/");
		tempPath.append(this.getClass().getSimpleName());
		tempPath.append(".xml");
		configPath = tempPath.toString();

		try (InputStream in = this.getClass().getClassLoader().getResourceAsStream(configPath);
				BufferedReader reader = new BufferedReader(new InputStreamReader(in, Charset.forName("utf-8")));) {
			StringBuilder content = new StringBuilder();
			for (String line; (line = reader.readLine()) != null;) {
				content.append(line);
			}
			contents = content.toString().split(splitString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected String packSendXmlMsg(String... parameters) {
		StringBuilder sendXmlMsg = new StringBuilder();
		int parametersLen = parameters.length;
		for (int x = 0; x < contents.length; x++) {
			sendXmlMsg.append(contents[x]);
			if (x < parametersLen) {
				sendXmlMsg.append(parameters[x]);
			}
		}
		return sendXmlMsg.toString();
	}

	protected Document unpackReceXmlMsg(String receXmlMsg) {
		try {
			SAXBuilder builder = new SAXBuilder();
			builder.setEntityResolver(new IgnoreDTDEntityResolver());
			return builder.build(new StringReader(receXmlMsg));
		} catch (Exception e) {
			StringBuilder sb = new StringBuilder();
			sb.append("解析XML出现问题。[");
			sb.append(receXmlMsg);
			sb.append("]");
			throw new RuntimeException(sb.toString(), e);
		}

	}
	
	@Override
	public Document handle(String... parameters) {
		String send = this.packSendXmlMsg(parameters);
		String rece = this.eomClient.send(send);
		return this.unpackReceXmlMsg(rece);
	}
	
}
