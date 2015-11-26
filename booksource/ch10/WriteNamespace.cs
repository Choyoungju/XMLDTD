using System;
using System.IO;
using System.Xml;

namespace booksource.ch10
{
	public class WriteNamespace
	{
    public static void Main(string[] args)
    {
      StringWriter stringWriter = new StringWriter();
      XmlWriterSettings settings = new XmlWriterSettings();
      settings.Indent = true;
      XmlWriter xmlWriter = XmlWriter.Create(stringWriter, settings);

      string soapNamespace = "http://schemas.xmlsoap.org/soap/envelope/";
      string bmlNamespace = "http://www.mincheol.com/bml";

      xmlWriter.WriteStartElement("soap", "Envelope", soapNamespace);
      xmlWriter.WriteStartElement("Body", soapNamespace);

      xmlWriter.WriteStartElement("booklist", bmlNamespace);
      xmlWriter.WriteStartElement("book", bmlNamespace);
      xmlWriter.WriteStartElement("title", bmlNamespace);
      xmlWriter.WriteString(".NET 개발자를 위한 XML Programming");
      xmlWriter.WriteEndElement();
      xmlWriter.WriteEndElement();
      xmlWriter.WriteEndElement();

      xmlWriter.WriteEndElement();
			xmlWriter.WriteEndElement();

			xmlWriter.Close();
      Console.WriteLine(stringWriter.ToString());
		}
	}
}
