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
	
	//�ʵ�
	public JTextArea txtRequestXml;
	public JTextArea txtResponseXml;
	public JButton btnSendRequestXml;
	public JButton btnRequestList, btnRequestOrder, btnRequestOrderView;

	public DocumentBuilderFactory parserFactory;
	public DocumentBuilder parser;
	
	public String xslFilePath;

	//������
	public OrderClient() {
		//â ����
		this.setTitle("OrderClient");
		
		//���� �г� ����
		JPanel pNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		btnRequestList = new JButton("��ǰ ��� ��û");
		btnRequestOrder = new JButton("��ǰ �ֹ� ��û");
		btnRequestOrderView = new JButton("�ֹ� ���� ����");
		pNorth.add(btnRequestList);
		pNorth.add(btnRequestOrder);
		pNorth.add(btnRequestOrderView);
		
		//�߾� �г� ����
		JPanel pCenter = new JPanel(new BorderLayout());
		
		JPanel pCenterNorth = new JPanel(new GridLayout(1,2,5,5));
		pCenterNorth.add(new JLabel("��û XML ����"));
		pCenterNorth.add(new JLabel("���� XML ����"));
		
		JPanel pCenterCenter = new JPanel(new GridLayout(1,2,5,5));
		txtRequestXml = new JTextArea();
		txtResponseXml = new JTextArea();
		pCenterCenter.add(new JScrollPane(txtRequestXml));
		pCenterCenter.add(new JScrollPane(txtResponseXml));
		
		pCenter.add("North", pCenterNorth);
		pCenter.add("Center", pCenterCenter);
		
		//���� �г� ����
		JPanel pSouth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		btnSendRequestXml = new JButton("��û XML ������  ������  ����");
		pSouth.add(btnSendRequestXml);
		
		//�����ӿ� ���̱�
		getContentPane().add("North", pNorth);
		getContentPane().add("Center", pCenter);
		getContentPane().add("South", pSouth);	
		
		//DOM �ļ� ����
		createParser();
		
		//�̺�Ʈ ó��
		eventControl();
	}
	
	//�޼���
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
			//�� DOM ��ü ����
			Document document = parser.newDocument();
			//<request> ����
			Element eRequest = document.createElementNS("http://www.mincheol.com/oml","request");
			document.appendChild(eRequest);
			//<action> ����
			Element eAction = document.createElement("action");
			eAction.setTextContent("ListAction");
			eRequest.appendChild(eAction);
			//��û XML ���� ����
			xmlView(txtRequestXml, document);
			//���� XML ���� ��ȯ�� XSL ����
			xslFilePath = "ch14/client/productlist.xsl";
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void btnRequestOrder_Click()	{
		//�� DOM ��ü ����
		Document document = parser.newDocument();
		//<request> ����
		Element eRequest = document.createElementNS("http://www.mincheol.com/oml","request");
		document.appendChild(eRequest);
		//<action> ����
		Element eAction = document.createElement("action");
		eAction.setTextContent("OrderAction");
		eRequest.appendChild(eAction);
		//<data> ����
		Element eData = document.createElement("data");
		eRequest.appendChild(eData);
		//<order> ����
		Element eOrder = document.createElement("order");
		eData.appendChild(eOrder);
		//<userid> ����
		Element eUserId = document.createElement("userid");
		eUserId.setTextContent("white");
		eOrder.appendChild(eUserId);
		//<username> ����
		Element eUserName = document.createElement("username");
		eUserName.setTextContent("���Ͼ�");
		eOrder.appendChild(eUserName);
		//<productid> ����
		Element eProductId = document.createElement("productid");
		eProductId.setTextContent("p1004");
		eOrder.appendChild(eProductId);
		//<productname> ����
		Element eProductName = document.createElement("productname");
		eProductName.setTextContent("Ȩ������");
		eOrder.appendChild(eProductName);
		//<qty> ����
		Element eQty = document.createElement("qty");
		eQty.setTextContent("1");
		eOrder.appendChild(eQty);
		
		//��û XML ���� ����
		xmlView(txtRequestXml, document);
		
		//���� XML ���� ��ȯ�� XSL ����
		xslFilePath = null;
	}
	
	public void btnRequestOrderView_Click() {
		try {
			//�� DOM ��ü ����
			Document document = parser.newDocument();
			//<request> ����
			Element eRequest = document.createElementNS("http://www.mincheol.com/oml","request");
			document.appendChild(eRequest);
			//<action> ����
			Element eAction = document.createElement("action");
			eAction.setTextContent("OrderViewAction");
			eRequest.appendChild(eAction);
			//��û XML ���� ����
			xmlView(txtRequestXml, document);
			//���� XML ���� ��ȯ�� XSL ����
			xslFilePath = "ch14/client/orderview.xsl";			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void xmlView(JTextArea textArea, Document document) {
		try {
			//XSL ��ȯ�� ����
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			//XML ���� ���
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
			//XSL ������ �����Ǿ����� �˻�
			if(xslFilePath == null) return;
			
			//��ȯ ����� �ִ� XSL ��ȯ�� ����
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Source xslSource = new StreamSource(xslFilePath);
			Transformer transformer = transformerFactory.newTransformer(xslSource);
			
			//����  XML ������ HTML ������ result.html�� ��ȯ�Ͽ� ���� 
			StringReader reader = new StringReader(txtResponseXml.getText());
			Source xmlSource = new StreamSource(reader);
			Result xmlResult = new StreamResult("ch14/client/result.html");
			transformer.transform(xmlSource, xmlResult);
			
			//���ͳ��ͽ��÷η����� result.html ����
			String command = "C:/Program Files/Internet Explorer/iexplore.exe C:/XMLSW/booksource/ch14/client/result.html";
			Process process = Runtime.getRuntime().exec(command);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void btnSendRequestXml_Click() {
		try {
			//���� ����
			Socket socket = new Socket("localhost", 50001);
			
			//��û XML ���� ������
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(txtRequestXml.getText());
			
			//���� XML ���� �ޱ�
			DataInputStream in = new DataInputStream(socket.getInputStream());
			String responseXml = in.readUTF();	
			
			//DOM ����
			StringReader stringReader = new StringReader(responseXml);
			InputSource xmlInputSource = new InputSource(stringReader);
			Document document = parser.parse(xmlInputSource);
			
			//XML ���� ����
			xmlView(txtResponseXml, document);
			
			//IE���� ����
			ieView();	
			
			//���� �ݱ�
			socket.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//���� �޼���
	public static void main(String args[]) {
		// XMLJFrame ��ü ����
		OrderClient orderClient = new OrderClient();
		// ������ ����ʷ� ���� 
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(orderClient);
	    } catch(Exception e) {
	    }
		// Frame ������ �ֱ�
	    orderClient.setSize(550,470);
		// Frame ���� �ֱ�
	    orderClient.setVisible(true);
	}
	
}
