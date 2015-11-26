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
		//���� XML ���� DOM ��ü ����
		DocumentBuilderFactory parserFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = parserFactory.newDocumentBuilder();		
		Document docResponse = parser.newDocument();
		Element eResponse = docResponse.createElement("response");
		docResponse.appendChild(eResponse);
		Element eOrderResult = docResponse.createElement("validationerror");
		eOrderResult.setTextContent("�ùٸ� ��û XML ������ �ƴմϴ�.");
		eResponse.appendChild(eOrderResult);
		
		//���� XML ���� ���ڿ� ���
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();		
		Source xmlSourceResponse = new DOMSource(docResponse);
		StringWriter stringWriter = new StringWriter();
		Result xmlResultResponse = new StreamResult(stringWriter);
		transformer.transform(xmlSourceResponse, xmlResultResponse);
		String responseXml = stringWriter.toString();
		
		//Ŭ���̾�Ʈ�� ���� XML ���� ������
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		out.writeUTF(responseXml);	
	}

}
