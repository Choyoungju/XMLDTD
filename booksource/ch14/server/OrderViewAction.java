package ch14.server;

import java.io.*;
import java.net.*;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;

public class OrderViewAction extends Action {

	public void execute(Socket socket, Document docRequest) throws Exception {		
		//변환기 생성
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Source xslSource = new StreamSource("ch14/server/orderview.xsl");
		Transformer transformer = transformerFactory.newTransformer(xslSource);
		
		//응답 XML 문서 생성
		Source xmlSource = new StreamSource("ch14/server/orders.xml");
		StringWriter stringWriter = new StringWriter();
		Result xmlResult = new StreamResult(stringWriter);
		transformer.transform(xmlSource, xmlResult);
		String responseXml = stringWriter.toString();
		
		//클라이언트로 응답 XML 문서 전송
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		out.writeUTF(responseXml);
	}

}
