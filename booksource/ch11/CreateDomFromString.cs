using System.Xml;

namespace booksource.ch11
{
  class CreateDomFromString
  {
    static void Main()
    {
      string strXML =
        "<?xml version='1.0'?>" +
        "<booklist>" +
        "	<book id='b2' kind='computer'>" +
        "		<title>기초에서 실무까지 XML</title>" +
        "		<author>신민철</author>" +
        "		<publisher>프리렉</publisher>" +
        "		<price>35000</price>" +
        "	</book>" +
        "</booklist>";
      XmlDocument xmlDocument = new XmlDocument();
      xmlDocument.LoadXml(strXML);
    }
  }
}
