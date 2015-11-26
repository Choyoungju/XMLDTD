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
      Console.Write("ù��° å ����: ");
      Console.WriteLine("\t" + "id=" + eFirstBook.GetAttribute("id"));

      XmlElement eLastBook = (XmlElement)eBooklist.LastChild;
      Console.Write("������ å ����: ");
      Console.WriteLine("\t" + "id=" + eLastBook.GetAttribute("id"));
    }
  }
}
