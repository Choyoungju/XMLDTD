package ch13;

import javax.xml.xpath.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class FindByXpath {
	public static void main(String[] args) throws Exception {
		//XPath 객체 생성
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		
		//검색 원본 InputSource 객체 생성
		InputSource xmlSource = new InputSource("ch13/bml.xml");
		
		System.out.println("--책아이디로 제목 찾기--");
		String title = xpath.evaluate("/booklist/book/title[../@id='b2']", xmlSource);
		System.out.println(title);
		
		System.out.println("--책아이디로 book 엘리먼트 찾기--");
		Node nBook = (Node)xpath.evaluate("/booklist/book[@id='b2']", xmlSource, XPathConstants.NODE);
		Element eBook = (Element) nBook;
		System.out.println(eBook.getAttribute("kind"));
		
		System.out.println("--책의 총수 얻기--");
		Double bookNo = (Double) xpath.evaluate("count(/booklist/book)", xmlSource, XPathConstants.NUMBER);
		System.out.println(bookNo.doubleValue());
		
		System.out.println("--모든 책 제목을 찾기--");
		NodeList nl = (NodeList) xpath.evaluate("/booklist/book/title", xmlSource, XPathConstants.NODESET);
		for(int i=0; i<nl.getLength(); i++)
		{
			Element eTitle = (Element) nl.item(i);
			System.out.println(eTitle.getTextContent());
		}		
	}
}
