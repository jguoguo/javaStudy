package com.bjpowernode.drp.util;

import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

public class TestXmlWriter {
	public static void main(String[] args) {
		Document doc=DocumentHelper.createDocument();
		Element rootElt=doc.addElement("items");
		Element itemElt=rootElt.addElement("item");
		Element idElt=itemElt.addElement("id");
		idElt.setText("100023");
		Element nameElt=itemElt.addElement("name");
		nameElt.setText("¼ªÁÖÊ¡");
		String xmlString=doc.asXML();
		System.out.println(xmlString);
//		XMLWriter writer;
//		try {
//			writer = new XMLWriter(new FileWriter("c:\\test.xml"));
//			writer.write(doc);
//			writer.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}
}
