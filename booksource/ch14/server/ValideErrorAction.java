package ch14.server;

import java.io.*;
import java.net.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;

public class ValideErrorAction extends Action {

	public void execute(Socket socket, Document docRequest) throws Exception {
		//응답 XML 문서 DOM 객체 생성
		DocumentBuilderFactory parserFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = parserFactory.newDocumentBuilder();		
		Document docResponse = parser.newDocument();
		Element eResponse = docResponse.createElement("response");
		docResponse.appendChild(eResponse);
		Element eOrderResult = docResponse.createElement("validationerror");
		eOrderResult.setTextContent("올바른 요청 XML 문서가 아닙니다.");
		eResponse.appendChild(eOrderResult);
		
		//응답 XML 문서 문자열 얻기
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();		
		Source xmlSourceResponse = new DOMSource(docResponse);
		StringWriter stringWriter = new StringWriter();
		Result xmlResultResponse = new StreamResult(stringWriter);
		transformer.transform(xmlSourceResponse, xmlResultResponse);
		String responseXml = stringWriter.toString();
		
		//클라이언트로 응답 XML 문서 보내기
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		out.writeUTF(responseXml);	
	}

}
