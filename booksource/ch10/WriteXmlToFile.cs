using System.Xml;
using System.Text;

namespace booksource.ch10
{
	public class WriteXmlToFile
	{
		public static void Main(string[] args)
		{
      string filePath = @"C:\Temp\booklist.xml";
      XmlWriterSettings settings = new XmlWriterSettings();
      settings.Encoding = Encoding.UTF8;
      settings.Indent = true;
      XmlWriter xmlWriter = XmlWriter.Create(filePath, settings);

      xmlWriter.WriteStartElement("booklist");
      xmlWriter.WriteStartElement("book");
      xmlWriter.WriteStartElement("title");
      xmlWriter.WriteString(".NET 개발자를 위한 XML Programming");
      xmlWriter.WriteEndElement();
      xmlWriter.WriteEndElement();
      xmlWriter.WriteEndElement();

			xmlWriter.Close();
		}
	}
}
