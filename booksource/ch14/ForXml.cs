using System;
using System.Data;
using System.Data.SqlClient;
using System.Xml;
using System.IO;

namespace booksource.ch14
{
  class ForXml
  {
    static void Main()
    {
      string strConn = "Data Source=localhost;Initial Catalog=booksourcedb;Integrated Security=True";
      SqlConnection conn = new SqlConnection(strConn);
      SqlCommand command = new SqlCommand();
      command.Connection = conn;
      command.CommandText = 
          "SELECT 	1		        AS Tag, " +
          "               NULL		AS Parent," +
          "             	NULL		AS [booklist!1]," +
          "               NULL		AS [book!2!bid]," +
          "             	NULL		AS [book!2!kind]," +
          "             	NULL		AS [book!2!title!element]," +
          "             	NULL		AS [book!2!publisher!element]," +
          "               NULL		AS [book!2!price!element] " +
          "UNION ALL " +
          "SELECT 	2, 1, NULL, bid, kind, title, publisher, price " +
          "FROM book WHERE bid='b1' " +
          "FOR XML EXPLICIT";
      command.CommandType = CommandType.Text;

      conn.Open();
      XmlReader xmlReader = command.ExecuteXmlReader();
      XmlDocument xmlDocument = new XmlDocument();
      xmlDocument.Load(xmlReader);
      xmlReader.Close();
      conn.Close();

      //--> XML 문서 처리

      StringWriter stringWriter = new StringWriter();
      xmlDocument.Save(stringWriter);
      string strXml = stringWriter.ToString();
      Console.WriteLine(strXml);
    }
  }
}
