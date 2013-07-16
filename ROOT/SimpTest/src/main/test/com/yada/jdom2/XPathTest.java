package com.yada.jdom2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import org.junit.Test;

import com.yada.eom.core.IgnoreDTDEntityResolver;

public class XPathTest {

	@Test
	public void testXPath() throws URISyntaxException {
		String uri = XPathTest.class.getResource("") +"XPathTest.xml" ;
		System.out.println(uri);
		Path path = Paths.get(new URI(uri));
		StringBuilder xml = new StringBuilder();
		try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));){
			for(String temp ; (temp = reader.readLine())!= null ; ){
				xml.append(temp);
			} 
		}catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		SAXBuilder builder = new SAXBuilder();
		builder.setEntityResolver(new IgnoreDTDEntityResolver());
		try {
			Document doc = builder.build(new StringReader(xml.toString()));
			
			XPathFactory xPathFactory = XPathFactory.instance();
			XPathExpression<Object> expression = xPathFactory.compile("/Conversation/Message/RepeatGroup/GroupItem");
			List<Object> groupItems = expression.evaluate(doc);
			for(int i = 0 ; i < groupItems.size() ; i++){
				expression = xPathFactory.compile("Entity/Field[@FieldName='statementNo']");
				Object o = expression.evaluate(groupItems.get(i)).get(0);
				System.out.println("statementNo[" + ((Element)o).getAttributeValue("FieldValue") + "]");
			}
			
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
