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
        "		<title>���ʿ��� �ǹ����� XML</title>" +
        "		<author>�Ź�ö</author>" +
        "		<publisher>������</publisher>" +
        "		<price>35000</price>" +
        "	</book>" +
        "</booklist>";

      StringReader stringReader = new StringReader(strXML);

      XmlReader xmlReader = XmlReader.Create(stringReader);
      while (xmlReader.Read())
      {
        //XML ���� ó��
      }
      xmlReader.Close();
    }
  }
}
