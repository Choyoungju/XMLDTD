using System;
using System.Xml;

namespace booksource.ch11
{
  class FindDocumentElement
  {
    static void Main()
    {
      string filePath = @"..\..\ch11\booklist.xml";
      XmlDocument xmlDocument = new XmlDocument();
      xmlDocument.Load(filePath);

      XmlElement eBooklist = xmlDocument.DocumentElement;

      Console.WriteLine(eBooklist.Name);
    }
  }
}
