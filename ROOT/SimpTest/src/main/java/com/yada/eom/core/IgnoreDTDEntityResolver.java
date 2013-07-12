package com.yada.eom.core;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * 不加载DTD约束文件.防止查找不到约束无法解析
 * @author misaka
 *
 */
public class IgnoreDTDEntityResolver implements EntityResolver {

	@Override
	public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
		String errorMsg = "";
		return new InputSource(new ByteArrayInputStream(errorMsg.getBytes()));
	}

}
