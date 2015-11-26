package ch12;

import javax.xml.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import javax.xml.transform.*;
import javax.xml.validation.*;

public class ValidatorUtil implements ErrorHandler {

	private static boolean result;
	
	public void warning(SAXParseException exception) throws SAXException {
	}
	public void error(SAXParseException exception) throws SAXException {
		ValidatorUtil.result = false; 
	}	
	public void fatalError(SAXParseException exception) throws SAXException {
		ValidatorUtil.result = false;   
	}	
	
	public static boolean validateXml(InputSource sourceXml) {
		ValidatorUtil.result = true;
		try {		
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(true);	
			factory.setNamespaceAware(true);
			factory.setFeature("http://apache.org/xml/features/validation/schema",true);
		 	SAXParser parser = factory.newSAXParser();
		 	
			XMLReader reader = parser.getXMLReader();
			reader.setErrorHandler(new ValidatorUtil());
			reader.parse(sourceXml);
		} catch(Exception e) {
			ValidatorUtil.result = false;
		}
		return ValidatorUtil.result;
	}	
	
	
	public static boolean validateXmlSchema(Source sourceXml, Source[] sourceXsd) {
		ValidatorUtil.result = true;
		try {
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = schemaFactory.newSchema(sourceXsd);
			Validator validator = schema.newValidator();
			validator.setErrorHandler(new ValidatorUtil());
			validator.validate(sourceXml);
		} catch(Exception e) {
			ValidatorUtil.result = false;
		}
		return ValidatorUtil.result;
	}

}