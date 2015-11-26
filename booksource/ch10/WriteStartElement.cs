using System;
using System.IO;
using System.Xml;
using System.Text;

namespace booksource.ch10
{
	public class WriteStartElement
	{
		[STAThread]
		public static void Main(string[] args)
		{
			string filePath = @"C:\Temp\book2.xml";
			XmlTextWriter xmlWriter = new XmlTextWriter(filePath, Encoding.UTF8);

      xmlWriter.WriteStartElement("booklist");
      xmlWriter.WriteStartElement("book");
      xmlWriter.WriteStartElement("title");
      xmlWriter.WriteString("XML Programming with .NET");
      xmlWriter.WriteEndElement();
      xmlWriter.WriteEndElement();
      xmlWriter.WriteEndElement();

			xmlWriter.Close();
		}
	}
}
