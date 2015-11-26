using System;
using System.Xml;
using System.IO;

namespace booksource.ch11
{
  class RemoveAttributeAndElement
  {
    static void Main()
    {
      string filePath = @"..\..\ch11\booklist.xml";
      XmlDocument xmlDocument = new XmlDocument();
      xmlDocument.Load(filePath);

      XmlElement eBooklist = xmlDocument.DocumentElement;

      XmlNodeList nlBooks = eBooklist.GetElementsByTagName("book");
      foreach (XmlElement eBook in nlBooks)
      {
        eBook.RemoveAttribute("kind");
      }

      XmlElement eLastBook = (XmlElement)eBooklist.LastChild;
      eBooklist.RemoveChild(eLastBook);

      StringWriter stringWriter = new StringWriter();
      xmlDocument.Save(stringWriter);
      Console.WriteLine(stringWriter.ToString());
    }
  }
}
