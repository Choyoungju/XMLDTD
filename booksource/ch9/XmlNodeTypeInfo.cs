using System;
using System.Xml;

namespace booksource.ch9
{
	public class XmlNodeTypeInfo
	{
		public static void Main(string[] args) 
		{
      string filePath = @"..\..\ch9\booklist.xml";

      XmlReader xmlReader = XmlReader.Create(filePath);

      /*
      XmlReaderSettings settings = new XmlReaderSettings();
      settings.IgnoreWhitespace = true;
      XmlReader xmlReader = XmlReader.Create(filePath, settings);
      */


			Console.WriteLine("{0,-20}{1,-20}{2,-20}", "NodeType", "Name", "Value");
			Console.WriteLine("{0,-20}{1,-20}{2,-20}","------------------","------------------","------------------");

			while(xmlReader.Read()) 
			{
				Console.WriteLine("{0,-20}{1,-20}{2,-20}",	xmlReader.NodeType, xmlReader.Name, 	xmlReader.Value);
			}		

			xmlReader.Close();
		}
	}
}
