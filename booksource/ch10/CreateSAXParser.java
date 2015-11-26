package ch10;

//JAXP 패키지
import javax.xml.parsers.*;

public class CreateSAXParser {
	public static void main(String args[]) throws Exception {
		//SAX 파서 공장 생성
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//SAX 파서 생성
		SAXParser parser = factory.newSAXParser();

		System.out.println("SAX 파서 객체 생성 성공");
	}	
}

