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
			System.out.println("OrderServer 구동");
			System.out.println("-------------------------");			
			while(true) {
				//연결 얻기
				Socket socket = ss.accept();
				
				//요청 XML 문서 얻기
				DataInputStream in = new DataInputStream(socket.getInputStream());
				String requestXml = in.readUTF();
				
				//요청 XML 문서 유효성 검사
				StringReader stringReader = new StringReader(requestXml);
				Source xmlSource = new StreamSource(stringReader);
				Source[] xsdSource = new Source[] {	new StreamSource("ch14/util/oml.xsd") };
				boolean isValide = ValidatorUtil.validateXmlSchema(xmlSource, xsdSource);
				if(isValide==false) {
					//유효성이 실패할 경우 ValideErrorAction 생성
					Action action = new ValideErrorAction();
					action.execute(socket, null);
					socket.close();
					continue;
				}
				
				//DOM 객체 생성
				stringReader = new StringReader(requestXml);
				InputSource xmlInputSource = new InputSource(stringReader);
				Document document = parser.parse(xmlInputSource);
				
				//요청 Action 얻기
				NodeList nodeList = document.getElementsByTagName("action");
				Element eAction = (Element) nodeList.item(0);				
				String actionName = eAction.getTextContent();	
				
				//요청 Action 실행
				Class actionClass = Class.forName("ch14.server." + actionName);
				Action action = (Action) actionClass.newInstance();
				action.execute(socket, document);
				
				//연결 닫기
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

