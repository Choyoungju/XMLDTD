package ch14.server;

import java.io.*;
import java.net.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;
import org.xml.sax.*;

import ch14.util.*;

public class OrderServer {
	
	public DocumentBuilderFactory parserFactory;
	public DocumentBuilder parser;
	
	public OrderServer() {
		try {
			parserFactory = DocumentBuilderFactory.newInstance();
			parser = parserFactory.newDocumentBuilder();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void startServer() {
		try {		
			ServerSocket ss = new ServerSocket(50001);
			System.out.println("-------------------------");
			System.out.println("OrderServer ����");
			System.out.println("-------------------------");			
			while(true) {
				//���� ���
				Socket socket = ss.accept();
				
				//��û XML ���� ���
				DataInputStream in = new DataInputStream(socket.getInputStream());
				String requestXml = in.readUTF();
				
				//��û XML ���� ��ȿ�� �˻�
				StringReader stringReader = new StringReader(requestXml);
				Source xmlSource = new StreamSource(stringReader);
				Source[] xsdSource = new Source[] {	new StreamSource("ch14/util/oml.xsd") };
				boolean isValide = ValidatorUtil.validateXmlSchema(xmlSource, xsdSource);
				if(isValide==false) {
					//��ȿ���� ������ ��� ValideErrorAction ����
					Action action = new ValideErrorAction();
					action.execute(socket, null);
					socket.close();
					continue;
				}
				
				//DOM ��ü ����
				stringReader = new StringReader(requestXml);
				InputSource xmlInputSource = new InputSource(stringReader);
				Document document = parser.parse(xmlInputSource);
				
				//��û Action ���
				NodeList nodeList = document.getElementsByTagName("action");
				Element eAction = (Element) nodeList.item(0);				
				String actionName = eAction.getTextContent();	
				
				//��û Action ����
				Class actionClass = Class.forName("ch14.server." + actionName);
				Action action = (Action) actionClass.newInstance();
				action.execute(socket, document);
				
				//���� �ݱ�
				socket.close();
			}			
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static void main(String[] args) {
		new OrderServer().startServer();		
	}

}

