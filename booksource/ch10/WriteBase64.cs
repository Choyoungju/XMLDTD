using System;
using System.IO;
using System.Xml;

namespace booksource.ch10
{
	public class WriteBase64
	{
		public static void Main(string[] args) 
		{
			string picturePath = @"..\..\Ch10\book.gif";
			FileStream fileStream = new FileStream(picturePath, FileMode.Open);
			int totalByteNo = (int) fileStream.Length;
			byte[] byteDatas = new byte[totalByteNo];
			fileStream.Read(byteDatas, 0, totalByteNo);
			fileStream.Close();

      StringWriter stringWriter = new StringWriter();
      XmlWriterSettings settings = new XmlWriterSettings();
      settings.Indent = true;
      XmlWriter xmlWriter = XmlWriter.Create(stringWriter, settings);

      xmlWriter.WriteStartElement("booklist");
			  xmlWriter.WriteStartElement("book");
				  xmlWriter.WriteStartElement("title");
					  xmlWriter.WriteString(".NET 개발자를 위한 XML Programming");
				  xmlWriter.WriteEndElement();

          xmlWriter.WriteStartElement("description");
            xmlWriter.WriteCData("혼자서도 학습할 수 있는 <책> 입니다.");
          xmlWriter.WriteEndElement();
  				
				  xmlWriter.WriteStartElement("img");
					  xmlWriter.WriteBase64(byteDatas, 0, totalByteNo);
				  xmlWriter.WriteEndElement();
			  xmlWriter.WriteEndElement();
      xmlWriter.WriteEndElement();

			xmlWriter.Close();
      Console.WriteLine(stringWriter.ToString());
		}
	}
}
