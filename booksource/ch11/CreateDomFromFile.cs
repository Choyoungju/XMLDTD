using System.Xml;

namespace booksource.ch11
{
  class CreateDomFromFile
  {
    static void Main()
    {
      string filePath = @"..\..\ch11\booklist.xml";
      XmlDocument xmlDocument = new XmlDocument();
      xmlDocument.Load(filePath);
    }
  }
}
