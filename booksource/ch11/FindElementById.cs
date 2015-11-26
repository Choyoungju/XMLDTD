using System;
using System.Xml;

namespace booksource.ch11
{
	class FindElementById
	{
		static void Main()
		{
      string filePath = @"..\..\ch11\booklist.xml";
      XmlDocument xmlDocument = new XmlDocument();
      xmlDocument.Load(filePath);

			XmlElement element = xmlDocument.GetElementById("b2");

			String title = element.FirstChild.FirstChild.Value;
			Console.WriteLine(title);
		}
	}	
}
