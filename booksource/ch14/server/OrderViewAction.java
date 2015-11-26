package ch14.server;

import java.io.*;
import java.net.*;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;

public class OrderViewAction extends Action {

	public void execute(Socket socket, Document docRequest) throws Exception {		
		//��ȯ�� ����
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Source xslSource = new StreamSource("ch14/server/orderview.xsl");
		Transformer transformer = transformerFactory.newTransformer(xslSource);
		
		//���� XML ���� ����
		Source xmlSource = new StreamSource("ch14/server/orders.xml");
		StringWriter stringWriter = new StringWriter();
		Result xmlResult = new StreamResult(stringWriter);
		transformer.transform(xmlSource, xmlResult);
		String responseXml = stringWriter.toString();
		
		//Ŭ���̾�Ʈ�� ���� XML ���� ����
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		out.writeUTF(responseXml);
	}

}
