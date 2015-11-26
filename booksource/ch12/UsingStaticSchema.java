package ch12;

import org.xml.sax.*;

public class UsingStaticSchema {
	public static void main(String args[]) throws Exception {
		boolean isValide = false;
		
		/*
		//DTD ���� ��� ������ ������ ���
		InputSource sourceXml = new InputSource("ch12/booklist_dtd.xml");
		isValide = ValidatorUtil.validateXml(sourceXml);		
		*/
		
		//XML ��Ű�� ���� ��ΰ� ������ ���
		InputSource sourceXml = new InputSource("ch12/booklist_schema.xml");
		isValide = ValidatorUtil.validateXml(sourceXml);			
		
		
		if(isValide) {
			System.out.println("��ȿ��");
		} else {
			System.out.println("��ȿ���� ����");
		}
	}	
}