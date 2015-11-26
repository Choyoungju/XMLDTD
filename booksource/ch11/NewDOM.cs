using System;
using System.Xml;

namespace booksource.ch11
{
  class NewDOM
  {
    static void Main()
    {
      XmlDocument xmlDocument = new XmlDocument();

      XmlElement eBooklist = xmlDocument.CreateElement("booklist");
      xmlDocument.AppendChild(eBooklist);

      XmlElement eBook = xmlDocument.CreateElement("book");
      XmlElement eTitle = xmlDocument.CreateElement("title");
      XmlText txtTitle = xmlDocument.CreateTextNode("XML Programming with .NET");
      eTitle.AppendChild(txtTitle);
      eBook.AppendChild(eTitle);

      eBook.SetAttribute("id", "b10");
      eBook.SetAttribute("kind", "ÄÄÇ»ÅÍ");
      eBooklist.AppendChild(eBook);

      xmlDocument.Save(@"C:\Temp\booklist.xml");
    }
  }
}
