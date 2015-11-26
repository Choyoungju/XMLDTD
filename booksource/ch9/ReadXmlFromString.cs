using System;
using System.IO;
using System.Xml;

namespace booksource.ch9
{
  class ReadXmlFromString
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

      StringReader stringReader = new StringReader(strXML);

      XmlReader xmlReader = XmlReader.Create(stringReader);
      while (xmlReader.Read())
      {
        //XML 문서 처리
      }
      xmlReader.Close();
    }
  }
}
