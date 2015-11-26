package ch14.server;

import java.io.*;
import java.net.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;

public class OrderAction extends Action {

	public void execute(Socket socket, Document docRequest) throws Exception {
		//요청 문서에서 새주문 정보 얻기
		NodeList nlOrder = docRequest.getElementsByTagName("order");
		Element eOrder = (Element)nlOrder.item(0);
		
		//orders.xml 파일 내용을  DOM 객체로 생성
		DocumentBuilderFactory parserFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = parserFactory.newDocumentBuilder();		
		Document docOrders = parser.parse("ch14/server/orders.xml");

		//새주문 정보를 DOM 객체에 추가
		Element eOrders = docOrders.getDocumentElement();
		Element eNewOrder = (Element) docOrders.importNode(eOrder, true);
		eOrders.appendChild(eNewOrder);
		
		//DOM 객체를 orders.xml 파일에 저장
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		Source xmlSource = new DOMSource(docOrders);
		Result xmlResult = new StreamResult("ch14/server/orders.xml");
		transformer.transform(xmlSource, xmlResult);
		
		//응답 XML 문서 생성
		Document docResponse = parser.newDocument();
		Element eResponse = docResponse.createElement("response");
		docResponse.appendChild(eResponse);
		Element eOrderResult = docResponse.createElement("orderresult");
		eOrderResult.setTextContent("주문성공");
		eResponse.appendChild(eOrderResult);
		
		Source xmlSourceResponse = new DOMSource(docResponse);
		StringWriter stringWriter = new StringWriter();
		Result xmlResultResponse = new StreamResult(stringWriter);
		transformer.transform(xmlSourceResponse, xmlResultResponse);
		String responseXml = stringWriter.toString();
		
		//클라이언트로 응답 XML 문서 전송
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		out.writeUTF(responseXml);		
	}

}
