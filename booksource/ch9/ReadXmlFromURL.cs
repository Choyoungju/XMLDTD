using System;
using System.Xml;

namespace booksource.ch9
{
  class ReadXmlFromURL
  {
    static void Main()
    {
      string url = "http://localhost:8080/website/ch9/booklist.xml";
      XmlReader xmlReader = XmlReader.Create(url);
      while (xmlReader.Read())
      {
        //--> XML 문서 처리
      }
      xmlReader.Close();
      Console.WriteLine("URL로부터 XML 문서를 모두 읽었습니다.");
    }
  }
}

