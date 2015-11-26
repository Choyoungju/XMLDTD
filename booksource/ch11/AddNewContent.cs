using System;
using System.Xml;
using System.IO;

namespace booksource.ch11
{
  class AddNewContent
  {
    static void Main()
    {
      string filePath = @"..\..\ch11\booklist.xml";
      XmlDocument xmlDocument = new XmlDocument();
      xmlDocument.Load(filePath);

      XmlElement eBooklist = xmlDocument.DocumentElement;

      XmlElement eBook = xmlDocument.CreateElement("book");
      eBook.SetAttribute("id", "b4");
      eBook.SetAttribute("kind", "컴퓨터");
      eBooklist.AppendChild(eBook);

      XmlElement eTitle = xmlDocument.CreateElement("title");
      XmlText txtTitle = xmlDocument.CreateTextNode("XML Programming with .NET");
      eTitle.AppendChild(txtTitle);
      eBook.AppendChild(eTitle);

      XmlElement eAuthor = xmlDocument.CreateElement("author");
      XmlText txtAuthor = xmlDocument.CreateTextNode("신용권");
      eAuthor.AppendChild(txtAuthor);
      eBook.AppendChild(eAuthor);

      XmlElement ePublisher = xmlDocument.CreateElement("publisher");
      XmlText txtPublisher = xmlDocument.CreateTextNode("프리렉");
      ePublisher.AppendChild(txtPublisher);
      eBook.AppendChild(ePublisher);

      XmlElement ePrice = xmlDocument.CreateElement("price");
      XmlText txtPrice = xmlDocument.CreateTextNode("30000");
      ePrice.AppendChild(txtPrice);
      eBook.AppendChild(ePrice);

      StringWriter stringWriter = new StringWriter();
      xmlDocument.Save(stringWriter);

      Console.WriteLine(stringWriter.ToString());
    }
  }
}
