using System;
using System.Xml;

namespace booksource.ch11
{
	class FindAttribute
	{
		static void Main()
		{
      string filePath = @"..\..\ch11\booklist.xml";
      XmlDocument xmlDocument = new XmlDocument();
      xmlDocument.Load(filePath);

      XmlElement eBooklist = xmlDocument.DocumentElement;
      XmlElement eFirstBook = (XmlElement)eBooklist.FirstChild;

      XmlAttributeCollection attributes = eFirstBook.Attributes;
			for(int i=0; i<attributes.Count; i++) 
			{
				XmlAttribute attribute = (XmlAttribute) attributes[i];
				Console.WriteLine(attribute.Name + "\t" + attribute.Value);
			}

      string id = eFirstBook.GetAttribute("id");
			Console.WriteLine("id:\t" + id);
      string kind = eFirstBook.GetAttribute("kind");
			Console.WriteLine("kind:\t" + kind);

		}
	}	
}
