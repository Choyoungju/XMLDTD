using System;
using System.Xml;
using System.IO;

namespace booksource.ch10
{
  public class WriteElement
	{
		public static void Main(string[] args)
		{
      StringWriter stringWriter = new StringWriter();
      XmlWriterSettings settings = new XmlWriterSettings();
      settings.Indent = true;
      XmlWriter xmlWriter = XmlWriter.Create(stringWriter, settings);

      xmlWriter.WriteStartElement("booklist");
        xmlWriter.WriteStartElement("book");

          xmlWriter.WriteStartElement("title");
            xmlWriter.WriteString(".NET 개발자를 위한 XML Programming");
          xmlWriter.WriteEndElement();

          xmlWriter.WriteStartElement("img");
          xmlWriter.WriteEndElement();

        xmlWriter.WriteEndElement();
      xmlWriter.WriteEndElement();

      xmlWriter.Close();

      Console.WriteLine(stringWriter.ToString());
		}
	}
}
