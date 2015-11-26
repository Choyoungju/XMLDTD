using System;
using System.IO;
using System.Xml;

namespace booksource.ch10
{
	public class WriteAttribute
	{
		public static void Main(string[] args) 
		{
      StringWriter stringWriter = new StringWriter();
      XmlWriterSettings settings = new XmlWriterSettings();
      settings.Indent = true;
      XmlWriter xmlWriter = XmlWriter.Create(stringWriter, settings);

      xmlWriter.WriteStartElement("booklist");
			  xmlWriter.WriteStartElement("book");
				  xmlWriter.WriteAttributeString("id", "b3");

				  xmlWriter.WriteStartAttribute("kind");
					  xmlWriter.WriteString("컴퓨터");
					  xmlWriter.WriteEntityRef("amp");
					  xmlWriter.WriteString("언어");
				  xmlWriter.WriteEndAttribute();

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
