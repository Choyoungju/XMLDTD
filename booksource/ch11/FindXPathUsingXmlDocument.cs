using System;
using System.Xml.XPath;

namespace booksource.ch11
{
  class FindXPathUsingXPathDocument
	{
		static void Main()
		{
      string filePath = @"..\..\ch11\booklist.xml";
      XPathDocument xpathDocument = new XPathDocument(filePath);
      XPathNavigator xpathNavigator = xpathDocument.CreateNavigator();

      XPathNodeIterator xpathNodeIterator = xpathNavigator.Select("//booklist/book/title[../@kind='ÄÄÇ»ÅÍ']");

      while (xpathNodeIterator.MoveNext())
      {
        XPathNavigator navigatorTitle = xpathNodeIterator.Current;
        Console.WriteLine(navigatorTitle.Value);
      }
		}
	}	
}
