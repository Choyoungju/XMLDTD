using System;
using System.Data;
using System.Data.SqlClient;

namespace booksource.ch13
{
  class WriteXmlAndSchema
  {
    static void Main()
    {
      string strConn = "Data Source=localhost;Initial Catalog=booksourcedb;Integrated Security=True";
      string strSql = "SELECT * FROM book";
      SqlDataAdapter dataAdapter = new SqlDataAdapter(strSql, strConn);

      DataSet dataSet = new DataSet("booklist");
      dataAdapter.Fill(dataSet, "book");

      dataSet.WriteXml(@"C:\Temp\booklist.xml");
      dataSet.WriteXmlSchema(@"C:\Temp\booklist.xsd");
    }
  }
}
