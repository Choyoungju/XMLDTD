using System;
using System.Data;
using System.Data.SqlClient;
using System.Xml;

namespace booksource.ch13
{
	class XmlDataDocumentUpdate
	{
    static void Main(string[] args)
    {
      //DataAdapter 객체 생성
      string strConn = "Data Source=localhost;Initial Catalog=booksourcedb;Integrated Security=True";
      string strSql = "SELECT * FROM book";
      SqlDataAdapter dataAdapter = new SqlDataAdapter(strSql, strConn);
      SqlCommandBuilder builder = new SqlCommandBuilder(dataAdapter);

      //데이터베이스에서 데이터 가져오기
      DataSet dataSet = new DataSet("booklist");
      dataAdapter.Fill(dataSet, "book");

      //XmlDataDocument 객체 생성
      XmlDataDocument xdd = new XmlDataDocument(dataSet);

      //XPath로 수정을 할 책 찾기
      string xpath = "/booklist/book[bid='b2']";
      XmlElement eBook = (XmlElement)xdd.SelectSingleNode(xpath);

      //책 가격을 수정
      XmlElement ePrice = (XmlElement)eBook.ChildNodes[4];
      dataSet.EnforceConstraints = false;
      ePrice.InnerText = Convert.ToString(12000);
      dataSet.EnforceConstraints = true;

      //변경된 DataSet 내용 보여주기
      DataTable dataTable = dataSet.Tables["book"];
      dataTable.PrimaryKey = new DataColumn[] { dataTable.Columns["bid"] };
      DataRow dataRow = dataTable.Rows.Find("b2");
      Console.WriteLine("원래 책 가격: " + dataRow["price", DataRowVersion.Original]);
      Console.WriteLine("수정 책 가격: " + dataRow["price"]);

      //데이터베이스에 업데이트
      dataAdapter.Update(dataSet, "book");
    }
	}
}
