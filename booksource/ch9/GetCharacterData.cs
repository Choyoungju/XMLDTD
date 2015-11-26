using System;
using System.Xml;

namespace booksource.ch9
{
	public class GetCharacterData
	{
		[STAThread]
		public static void Main(string[] args) 
		{
      string filePath = @"..\..\ch9\booklist.xml";
      XmlReaderSettings settings = new XmlReaderSettings();
      settings.IgnoreWhitespace = true;
      XmlReader xmlReader = XmlReader.Create(filePath, settings);

			while(xmlReader.Read()) 
			{
				if(xmlReader.NodeType==XmlNodeType.Element && xmlReader.Name=="title") 
				{
					Console.WriteLine(xmlReader.ReadElementString());
				}
			}		

			xmlReader.Close();
		}
	}
}
