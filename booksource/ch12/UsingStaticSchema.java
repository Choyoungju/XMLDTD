package ch12;

import org.xml.sax.*;

public class UsingStaticSchema {
	public static void main(String args[]) throws Exception {
		boolean isValide = false;
		
		/*
		//DTD 문서 경로 지정가 지정된 경우
		InputSource sourceXml = new InputSource("ch12/booklist_dtd.xml");
		isValide = ValidatorUtil.validateXml(sourceXml);		
		*/
		
		//XML 스키마 문서 경로가 지정된 경우
		InputSource sourceXml = new InputSource("ch12/booklist_schema.xml");
		isValide = ValidatorUtil.validateXml(sourceXml);			
		
		
		if(isValide) {
			System.out.println("유효함");
		} else {
			System.out.println("유효하지 않음");
		}
	}	
}