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
        "		<title>���ʿ��� �ǹ����� XML</title>" +
        "		<author>�Ź�ö</author>" +
        "		<publisher>������</publisher>" +
        "		<price>35000</price>" +
        "	</book>" +
        "</booklist>";
      XmlDocument xmlDocument = new XmlDocument();
      xmlDocument.LoadXml(strXML);
    }
  }
}
