package ch11;

//JAXP 패키지
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

public class CreateXSLTransformer_Trans {
	public static void main(String[] args) throws Exception {
		// XSL 변환기 공장 생성
		TransformerFactory factory = TransformerFactory.newInstance();

		// XSL 문서의 정보를 Source 객체로 생성
		Source sourceXSL = new StreamSource("ch11/bml.xsl");

		// XSL 변환기 생성: 변환후 저장 및 전송 수행
		Transformer transformer = factory.newTransformer(sourceXSL);
		
		System.out.println("XSL 변환기 객체 생성 성공");
	}
}
