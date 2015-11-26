package ch11;

//JAXP 패키지
import javax.xml.transform.*;

public class CreateXSLTransformer_NoTrans {
	public static void main(String[] args) throws Exception {
		// XSL 변환기 공장 생성
		TransformerFactory factory = TransformerFactory.newInstance();

		// XSL 변환기 생성: 변환 기능이 없고, 저장 및 전송만 수행
		Transformer transformer = factory.newTransformer();

		System.out.println("XSL 변환기 객체 생성 성공");
	}
}
