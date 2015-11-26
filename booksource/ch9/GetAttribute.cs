using System;
using System.Xml;

namespace booksource.ch9
{
	public class GetAttribute
	{
		public static void Main(string[] args) 
		{
      string filePath = @"..\..\ch9\booklist.xml";
      XmlReader xmlReader = XmlReader.Create(filePath);

			while(xmlReader.Read()) 
			{
				if(xmlReader.NodeType==XmlNodeType.Element && xmlReader.Name=="book") 
				{

          Console.WriteLine(xmlReader.GetAttribute("id"));

					if(xmlReader.HasAttributes)
					{
						xmlReader.MoveToFirstAttribute();
						Console.WriteLine("\t" + xmlReader.Name + ":" + xmlReader.Value);
						while(xmlReader.MoveToNextAttribute()) 
						{
							Console.WriteLine("\t" + xmlReader.Name + ":" + xmlReader.Value);
						}
						xmlReader.MoveToElement();
					}
				}
			}		

			xmlReader.Close();
		}
	}
}
