package ch11;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;

public class DisplayToMonitor {
	public static void main(String[] args) throws Exception {
		// 변환기 생성
		TransformerFactory factory = TransformerFactory.newInstance();

		// XSL 문서의 정보를 Source 객체로 생성
		Source sourceXSL = new StreamSource("ch11/bml.xsl");

		// XSL 변환기 생성: 변환후 저장 및 전송 수행
		Transformer transformer = factory.newTransformer(sourceXSL);

		// 출력 속성 설정
		transformer.setOutputProperty(OutputKeys.ENCODING, "euc-kr");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");

		// DOMSource 객체 생성
		Source sourceXML = new StreamSource("ch11/bml.xml");

		// StreamResult 객체 생성
		Result resultXML =  new StreamResult(System.out);

		// 모니터로 출력하기
		transformer.transform(sourceXML, resultXML);	
	}
}