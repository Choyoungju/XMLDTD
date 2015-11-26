package ch13;

import javax.xml.xpath.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class FindByXpath {
	public static void main(String[] args) throws Exception {
		//XPath ��ü ����
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		
		//�˻� ���� InputSource ��ü ����
		InputSource xmlSource = new InputSource("ch13/bml.xml");
		
		System.out.println("--å���̵�� ���� ã��--");
		String title = xpath.evaluate("/booklist/book/title[../@id='b2']", xmlSource);
		System.out.println(title);
		
		System.out.println("--å���̵�� book ������Ʈ ã��--");
		Node nBook = (Node)xpath.evaluate("/booklist/book[@id='b2']", xmlSource, XPathConstants.NODE);
		Element eBook = (Element) nBook;
		System.out.println(eBook.getAttribute("kind"));
		
		System.out.println("--å�� �Ѽ� ���--");
		Double bookNo = (Double) xpath.evaluate("count(/booklist/book)", xmlSource, XPathConstants.NUMBER);
		System.out.println(bookNo.doubleValue());
		
		System.out.println("--��� å ������ ã��--");
		NodeList nl = (NodeList) xpath.evaluate("/booklist/book/title", xmlSource, XPathConstants.NODESET);
		for(int i=0; i<nl.getLength(); i++)
		{
			Element eTitle = (Element) nl.item(i);
			System.out.println(eTitle.getTextContent());
		}		
	}
}
