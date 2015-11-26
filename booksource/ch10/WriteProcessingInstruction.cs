using System;
using System.IO;
using System.Xml;

namespace booksource.ch10
{
	public class WriteProcessingInstruction
	{
    public static void Main(string[] args)
    {
      StringWriter stringWriter = new StringWriter();
      XmlWriterSettings settings = new XmlWriterSettings();
      settings.Indent = true;
      XmlWriter xmlWriter = XmlWriter.Create(stringWriter, settings);

			xmlWriter.WriteProcessingInstruction("xml-stylesheet", "type='text/xsl' href='bml.xsl'");

      xmlWriter.WriteStartElement("booklist");
        xmlWriter.WriteStartElement("book");
          xmlWriter.WriteStartElement("title");
            xmlWriter.WriteString(".NET 개발자를 위한 XML Programming");
          xmlWriter.WriteEndElement();
        xmlWriter.WriteEndElement();
      xmlWriter.WriteEndElement();

			xmlWriter.Close();
      Console.WriteLine(stringWriter.ToString());
		}
	}
}
