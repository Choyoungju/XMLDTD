using System;
using System.Xml;
using System.IO;

namespace booksource.ch11
{
  class ModifyData
  {
    static void Main()
    {
      string filePath = @"..\..\ch11\booklist.xml";
      XmlDocument xmlDocument = new XmlDocument();
      xmlDocument.Load(filePath);

      XmlElement eBooklist = xmlDocument.DocumentElement;

      XmlElement eFirstBook = (XmlElement)eBooklist.FirstChild;
      XmlElement eTitle = (XmlElement)eFirstBook.ChildNodes[0];
      eTitle.InnerText = ".NET 개발자를 위한 XML";
      eFirstBook.SetAttribute("kind", "프로그래밍 언어");

      StringWriter stringWriter = new StringWriter();
      xmlDocument.Save(stringWriter);
      Console.WriteLine(stringWriter.ToString());
    }
  }
}
