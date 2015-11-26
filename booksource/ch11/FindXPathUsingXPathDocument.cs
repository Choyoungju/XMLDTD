using System;
using System.Xml;

namespace booksource.ch11
{
	class FindXPathUsingXmlDocument
	{
		static void Main()
		{
      string filePath = @"..\..\ch11\booklist.xml";
      XmlDocument xmlDocument = new XmlDocument();
      xmlDocument.Load(filePath);

      string xpath = "//booklist/book/title[../@kind='ÄÄÇ»ÅÍ']";
      XmlNodeList nodeList = xmlDocument.SelectNodes(xpath);

      for (int i = 0; i < nodeList.Count; i++)
      {
        string title = nodeList[i].InnerText;
        Console.WriteLine(title);
      }
		}
	}	
}
