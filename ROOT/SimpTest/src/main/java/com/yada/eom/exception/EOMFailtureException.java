package com.yada.eom.exception;

import java.io.IOException;
import java.io.StringReader;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sema.eom.EOMException;
import com.yada.eom.core.IgnoreDTDEntityResolver;

public class EOMFailtureException extends Exception {
	private static final Logger logger = LoggerFactory.getLogger(EOMFailtureException.class);

	private static final long serialVersionUID = -5259636944644760994L;

	private String respCode;
	private String message;

	public EOMFailtureException(EOMException e) {
		message = e.getMessage();
		SAXBuilder builder = new SAXBuilder();
		builder.setEntityResolver(new IgnoreDTDEntityResolver());
		try {
			Document doc = builder.build(new StringReader(message));
			Element rootElement = doc.getRootElement();
			respCode = rootElement.getAttributeValue("ResultCode");
		} catch (JDOMException e1) {
			logger.error("", e1);
		} catch (IOException e1) {
			logger.error("", e1);
		}
	}

	public String getRespCode() {
		return respCode;
	}

	
}
