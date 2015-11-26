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
        //--> XML ���� ó��
      }
      xmlReader.Close();
      Console.WriteLine("URL�κ��� XML ������ ��� �о����ϴ�.");
    }
  }
}

