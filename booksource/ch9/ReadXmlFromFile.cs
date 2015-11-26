using System.Xml;

namespace booksource.ch9
{
  class ReadXmlFromFile
  {
    static void Main()
    {
      string filePath = @"..\..\ch9\booklist.xml";
      XmlReader xmlReader = XmlReader.Create(filePath);
      while (xmlReader.Read())
      {
        //--> XML 문서 처리
      }
      xmlReader.Close();
    }
  }
}
