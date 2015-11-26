using System;
using System.Xml;

namespace booksource.ch11
{
  class FindElementByTagName
  {
    static void Main()
    {
      string filePath = @"..\..\ch11\booklist.xml";
      XmlDocument xmlDocument = new XmlDocument();
      xmlDocument.Load(filePath);

      XmlNodeList titleNodeList = xmlDocument.GetElementsByTagName("title");
      for (int i = 0; i < titleNodeList.Count; i++)
      {
        XmlNode titleNode = titleNodeList[i];
        XmlNodeList childNodeList = titleNode.ChildNodes;
        XmlNode textNode = childNodeList[0];
        string value = textNode.Value;
        Console.WriteLine(value);
      }
    }
  }
}
