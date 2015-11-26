package ch12;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;

public class UsingDynamicSchema {
	public static void main(String args[]) throws Exception {
		boolean isValide = false;
		
		Source sourceXml = new StreamSource("ch12/booklist.xml");
		Source[] sourceXsd = new Source[] {	new StreamSource("http://localhost:8080/ch12/bml.xsd") };
		isValide = ValidatorUtil.validateXmlSchema(sourceXml, sourceXsd);

		if(isValide) {
			System.out.println("유효함");
		} else {
			System.out.println("유효하지 않음");
		}
	}	
}