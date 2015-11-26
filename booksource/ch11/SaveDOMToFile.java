package ch11;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class SaveDOMToFile {

	public static void main(String[] args) throws Exception {
		// DOM 파서 생성
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringElementContentWhitespace(true); 
		DocumentBuilder builder = factory.newDocumentBuilder();

		// XML 문서 파싱하기
		Document document = builder.parse("ch11/bml.xml");

		// 루트 엘리먼트 참조 얻기
		Element eRoot = document.getDocumentElement();

		// 변환기 생성
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();

		// DOMSource 객체 생성
		Source source = new DOMSource(document);

		// StreamResult 객체 생성
		Result result =  new StreamResult(new File("C:/Temp/bml2.xml"));

		// 파일로 저장하기
		transformer.transform(source, result);

		System.out.println("bml2.xml로 저장되었습니다.");		
	}

}