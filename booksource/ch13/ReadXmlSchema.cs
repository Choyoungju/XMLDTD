using System;
using System.Data;

namespace booksource.ch13
{
  class ReadXmlSchema
  {
    static void Main()
    {
      DataSet dataSet = new DataSet();

      dataSet.ReadXmlSchema(@"..\..\ch13\booklist.xsd");

      DisplaySchema.displayDataSetSchema(dataSet);
    }
  }
}
