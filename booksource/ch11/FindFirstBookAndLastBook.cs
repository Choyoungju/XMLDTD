using System;
using System.Xml;

namespace booksource.ch11
{
  class FindFirstBookAndLastBook
  {
    static void Main()
    {
      string filePath = @"..\..\ch11\booklist.xml";
      XmlDocument xmlDocument = new XmlDocument();
      xmlDocument.Load(filePath);

      XmlElement eBooklist = xmlDocument.DocumentElement;

      XmlElement eFirstBook = (XmlElement)eBooklist.FirstChild;
      Console.Write("첫번째 책 정보: ");
      Console.WriteLine("\t" + "id=" + eFirstBook.GetAttribute("id"));

      XmlElement eLastBook = (XmlElement)eBooklist.LastChild;
      Console.Write("마지막 책 정보: ");
      Console.WriteLine("\t" + "id=" + eLastBook.GetAttribute("id"));
    }
  }
}
