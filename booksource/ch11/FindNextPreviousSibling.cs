using System;
using System.Xml;

namespace booksource.ch11
{
  class FindNextPreviousSibling
  {
    static void Main()
    {
      string filePath = @"..\..\ch11\booklist.xml";
      XmlDocument xmlDocument = new XmlDocument();
      xmlDocument.Load(filePath);

      XmlElement eBooklist = xmlDocument.DocumentElement;
      
      XmlElement eFirstBook = (XmlElement) eBooklist.FirstChild;
      XmlElement eNextBook = (XmlElement) eFirstBook.NextSibling;

      XmlElement eLastBook = (XmlElement) eBooklist.LastChild;
      XmlElement ePreviousBook = (XmlElement)eLastBook.PreviousSibling;

      if (eNextBook == ePreviousBook)
      {
        Console.WriteLine("동일한 book 엘리먼트 입니다.");
      }
      else
      {
        Console.WriteLine("다른 book 엘리먼트 입니다.");
      }
    }
  }
}
