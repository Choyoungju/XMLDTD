using System;
using System.Data;
using System.Data.SqlClient;
using System.Xml;

namespace booksource.ch13
{
	class XmlDataDocumentSearch
	{
		static void Main(string[] args)
		{
      string strConn = "Data Source=localhost;Initial Catalog=booksourcedb;Integrated Security=True";
      string strSql = "SELECT * FROM book";
      SqlDataAdapter dataAdapter = new SqlDataAdapter(strSql, strConn);

      DataSet dataSet = new DataSet("booklist");
      dataAdapter.Fill(dataSet, "book");

      XmlDataDocument xdd = new XmlDataDocument(dataSet);

      string xpath = "/booklist/book[bid='b2']";
      XmlElement eBook = (XmlElement)xdd.SelectSingleNode(xpath);

      Console.WriteLine("bid = " + eBook.ChildNodes[0].InnerText);
      Console.WriteLine("kind = " + eBook.ChildNodes[1].InnerText);
      Console.WriteLine("title = " + eBook.ChildNodes[2].InnerText);
      Console.WriteLine("publisher = " + eBook.ChildNodes[3].InnerText);
      Console.WriteLine("price = " + eBook.ChildNodes[4].InnerText);
		}
	}
}
