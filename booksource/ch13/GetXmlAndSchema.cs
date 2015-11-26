using System;
using System.Data;
using System.Data.SqlClient;

namespace booksource.ch13
{
  class GetXmlAndSchema
  {
    static void Main()
    {
      string strConn = "Data Source=localhost;Initial Catalog=booksourcedb;Integrated Security=True";
      string strSql = "SELECT * FROM book";
      SqlDataAdapter dataAdapter = new SqlDataAdapter(strSql, strConn);

      DataSet dataSet = new DataSet("booklist");
      dataAdapter.Fill(dataSet, "book");

      string strXml = dataSet.GetXml();
      string strSchema = dataSet.GetXmlSchema();

      Console.WriteLine("[DataSet 내용을 XML 문서로 쓰기]");
      Console.WriteLine("------------------------------------");
      Console.WriteLine(strXml);

      Console.WriteLine("\n[DataSet 구조를 Schema 문서로 쓰기]");
      Console.WriteLine("------------------------------------");
      Console.WriteLine(strSchema);
    }
  }
}
