using System.Xml;

namespace booksource.ch11
{
  class CreateDomFromURL
  {
    static void Main()
    {
      string url = "http://localhost:8080/website/ch11/booklist.xml";
      XmlDocument xmlDocument = new XmlDocument();
      xmlDocument.Load(url);
    }
  }
}
