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
		//��û �������� ���ֹ� ���� ���
		NodeList nlOrder = docRequest.getElementsByTagName("order");
		Element eOrder = (Element)nlOrder.item(0);
		
		//orders.xml ���� ������  DOM ��ü�� ����
		DocumentBuilderFactory parserFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = parserFactory.newDocumentBuilder();		
		Document docOrders = parser.parse("ch14/server/orders.xml");

		//���ֹ� ������ DOM ��ü�� �߰�
		Element eOrders = docOrders.getDocumentElement();
		Element eNewOrder = (Element) docOrders.importNode(eOrder, true);
		eOrders.appendChild(eNewOrder);
		
		//DOM ��ü�� orders.xml ���Ͽ� ����
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		Source xmlSource = new DOMSource(docOrders);
		Result xmlResult = new StreamResult("ch14/server/orders.xml");
		transformer.transform(xmlSource, xmlResult);
		
		//���� XML ���� ����
		Document docResponse = parser.newDocument();
		Element eResponse = docResponse.createElement("response");
		docResponse.appendChild(eResponse);
		Element eOrderResult = docResponse.createElement("orderresult");
		eOrderResult.setTextContent("�ֹ�����");
		eResponse.appendChild(eOrderResult);
		
		Source xmlSourceResponse = new DOMSource(docResponse);
		StringWriter stringWriter = new StringWriter();
		Result xmlResultResponse = new StreamResult(stringWriter);
		transformer.transform(xmlSourceResponse, xmlResultResponse);
		String responseXml = stringWriter.toString();
		
		//Ŭ���̾�Ʈ�� ���� XML ���� ����
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		out.writeUTF(responseXml);		
	}

}
