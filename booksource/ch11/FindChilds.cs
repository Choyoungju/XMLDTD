using System;
using System.Xml;

namespace booksource.ch11
{
  class FindChilds
  {
    static void Main()
    {
      string filePath = @"..\..\ch11\booklist.xml";
      XmlDocument xmlDocument = new XmlDocument();
      xmlDocument.Load(filePath);

      XmlElement eBooklist = xmlDocument.DocumentElement;
      XmlElement eFirstBook = (XmlElement)eBooklist.FirstChild;

      XmlNodeList nlChilds = eFirstBook.ChildNodes;
      for (int i = 0; i < nlChilds.Count; i++)
      {
        XmlElement eChild = (XmlElement)nlChilds[i];
        Console.WriteLine(eChild.Name + ":" + eChild.InnerText);
      }
    }
  }
}
