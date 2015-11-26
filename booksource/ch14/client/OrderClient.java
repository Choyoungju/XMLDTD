package ch14.client;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;
import org.xml.sax.*;

public class OrderClient extends JFrame implements ActionListener {
	
	//필드
	public JTextArea txtRequestXml;
	public JTextArea txtResponseXml;
	public JButton btnSendRequestXml;
	public JButton btnRequestList, btnRequestOrder, btnRequestOrderView;

	public DocumentBuilderFactory parserFactory;
	public DocumentBuilder parser;
	
	public String xslFilePath;

	//생성자
	public OrderClient() {
		//창 제목
		this.setTitle("OrderClient");
		
		//북쪽 패널 구성
		JPanel pNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		btnRequestList = new JButton("상품 목록 요청");
		btnRequestOrder = new JButton("상품 주문 요청");
		btnRequestOrderView = new JButton("주문 내용 보기");
		pNorth.add(btnRequestList);
		pNorth.add(btnRequestOrder);
		pNorth.add(btnRequestOrderView);
		
		//중앙 패널 구성
		JPanel pCenter = new JPanel(new BorderLayout());
		
		JPanel pCenterNorth = new JPanel(new GridLayout(1,2,5,5));
		pCenterNorth.add(new JLabel("요청 XML 문서"));
		pCenterNorth.add(new JLabel("응답 XML 문서"));
		
		JPanel pCenterCenter = new JPanel(new GridLayout(1,2,5,5));
		txtRequestXml = new JTextArea();
		txtResponseXml = new JTextArea();
		pCenterCenter.add(new JScrollPane(txtRequestXml));
		pCenterCenter.add(new JScrollPane(txtResponseXml));
		
		pCenter.add("North", pCenterNorth);
		pCenter.add("Center", pCenterCenter);
		
		//남족 패널 구성
		JPanel pSouth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		btnSendRequestXml = new JButton("요청 XML 문서를  서버로  전송");
		pSouth.add(btnSendRequestXml);
		
		//프레임에 붙이기
		getContentPane().add("North", pNorth);
		getContentPane().add("Center", pCenter);
		getContentPane().add("South", pSouth);	
		
		//DOM 파서 생성
		createParser();
		
		//이벤트 처리
		eventControl();
	}
	
	//메서드
	public void createParser() {
		try {
			parserFactory = DocumentBuilderFactory.newInstance();
			parser = parserFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}		
	}
	public void eventControl() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);	
			}	
		});	
		
		btnRequestList.addActionListener(this);
		btnRequestOrder.addActionListener(this);	
		btnSendRequestXml.addActionListener(this);
		btnRequestOrderView.addActionListener(this);
	}	
	
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj==btnRequestList) btnRequestList_Click();
		if(obj==btnRequestOrder) btnRequestOrder_Click();
		if(obj==btnSendRequestXml) btnSendRequestXml_Click();
		if(obj==btnRequestOrderView) btnRequestOrderView_Click();
	}	

	public void btnRequestList_Click() {
		try {
			//새 DOM 객체 생성
			Document document = parser.newDocument();
			//<request> 생성
			Element eRequest = document.createElementNS("http://www.mincheol.com/oml","request");
			document.appendChild(eRequest);
			//<action> 생성
			Element eAction = document.createElement("action");
			eAction.setTextContent("ListAction");
			eRequest.appendChild(eAction);
			//요청 XML 문서 보기
			xmlView(txtRequestXml, document);
			//응답 XML 문서 변환용 XSL 지정
			xslFilePath = "ch14/client/productlist.xsl";
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void btnRequestOrder_Click()	{
		//새 DOM 객체 생성
		Document document = parser.newDocument();
		//<request> 생성
		Element eRequest = document.createElementNS("http://www.mincheol.com/oml","request");
		document.appendChild(eRequest);
		//<action> 생성
		Element eAction = document.createElement("action");
		eAction.setTextContent("OrderAction");
		eRequest.appendChild(eAction);
		//<data> 생성
		Element eData = document.createElement("data");
		eRequest.appendChild(eData);
		//<order> 생성
		Element eOrder = document.createElement("order");
		eData.appendChild(eOrder);
		//<userid> 생성
		Element eUserId = document.createElement("userid");
		eUserId.setTextContent("white");
		eOrder.appendChild(eUserId);
		//<username> 생성
		Element eUserName = document.createElement("username");
		eUserName.setTextContent("최하얀");
		eOrder.appendChild(eUserName);
		//<productid> 생성
		Element eProductId = document.createElement("productid");
		eProductId.setTextContent("p1004");
		eOrder.appendChild(eProductId);
		//<productname> 생성
		Element eProductName = document.createElement("productname");
		eProductName.setTextContent("홈씨어터");
		eOrder.appendChild(eProductName);
		//<qty> 생성
		Element eQty = document.createElement("qty");
		eQty.setTextContent("1");
		eOrder.appendChild(eQty);
		
		//요청 XML 문서 보기
		xmlView(txtRequestXml, document);
		
		//응답 XML 문서 변환용 XSL 지정
		xslFilePath = null;
	}
	
	public void btnRequestOrderView_Click() {
		try {
			//새 DOM 객체 생성
			Document document = parser.newDocument();
			//<request> 생성
			Element eRequest = document.createElementNS("http://www.mincheol.com/oml","request");
			document.appendChild(eRequest);
			//<action> 생성
			Element eAction = document.createElement("action");
			eAction.setTextContent("OrderViewAction");
			eRequest.appendChild(eAction);
			//요청 XML 문서 보기
			xmlView(txtRequestXml, document);
			//응답 XML 문서 변환용 XSL 지정
			xslFilePath = "ch14/client/orderview.xsl";			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void xmlView(JTextArea textArea, Document document) {
		try {
			//XSL 변환기 생성
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			//XML 문서 출력
			Source xmlSource = new DOMSource(document);
			StringWriter stringWriter = new StringWriter();
			Result xmlResult = new StreamResult(stringWriter);
			transformer.transform(xmlSource, xmlResult);
			textArea.setText(stringWriter.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void ieView() {
		try {
			//XSL 문서가 지정되었는지 검사
			if(xslFilePath == null) return;
			
			//변환 기능이 있는 XSL 변환기 생성
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Source xslSource = new StreamSource(xslFilePath);
			Transformer transformer = transformerFactory.newTransformer(xslSource);
			
			//응답  XML 문서를 HTML 파일인 result.html로 변환하여 저장 
			StringReader reader = new StringReader(txtResponseXml.getText());
			Source xmlSource = new StreamSource(reader);
			Result xmlResult = new StreamResult("ch14/client/result.html");
			transformer.transform(xmlSource, xmlResult);
			
			//인터넷익스플로러에서 result.html 열기
			String command = "C:/Program Files/Internet Explorer/iexplore.exe C:/XMLSW/booksource/ch14/client/result.html";
			Process process = Runtime.getRuntime().exec(command);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void btnSendRequestXml_Click() {
		try {
			//연결 열기
			Socket socket = new Socket("localhost", 50001);
			
			//요청 XML 문서 보내기
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(txtRequestXml.getText());
			
			//응답 XML 문서 받기
			DataInputStream in = new DataInputStream(socket.getInputStream());
			String responseXml = in.readUTF();	
			
			//DOM 생성
			StringReader stringReader = new StringReader(responseXml);
			InputSource xmlInputSource = new InputSource(stringReader);
			Document document = parser.parse(xmlInputSource);
			
			//XML 문서 보기
			xmlView(txtResponseXml, document);
			
			//IE에서 보기
			ieView();	
			
			//연결 닫기
			socket.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//메인 메서드
	public static void main(String args[]) {
		// XMLJFrame 객체 생성
		OrderClient orderClient = new OrderClient();
		// 윈도우 룩앤필로 변경 
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(orderClient);
	    } catch(Exception e) {
	    }
		// Frame 사이즈 주기
	    orderClient.setSize(550,470);
		// Frame 보여 주기
	    orderClient.setVisible(true);
	}
	
}
