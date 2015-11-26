using System.Data;

namespace booksource.ch13
{
  class InferXmlSchema
  {
    static void Main()
    {
      DataSet dataSet = new DataSet();

      string[] ignoreNamesapces = {
        "http://www.shop.com/pml",
        "http://www.shop.com/cml"
      };
      dataSet.InferXmlSchema(@"..\..\ch13\orderlist.xml", ignoreNamesapces);

      DisplaySchema.displayDataSetSchema(dataSet);
    }
  }
}
