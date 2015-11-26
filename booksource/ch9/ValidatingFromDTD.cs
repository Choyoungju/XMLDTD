using System.Xml;
using System.Xml.Schema;
using System;

namespace booksource.ch9
{
  class ValidatingFromDTD
  {
    static void ValidationCallBack(object sender, ValidationEventArgs e)
    {
      Console.WriteLine("유효성 에러: {0}", e.Message);
    }
  
    static void Main()
    {
      string filePath = @"..\..\ch9\booklist_dtd.xml";

      XmlReaderSettings settings = new XmlReaderSettings();
      settings.ProhibitDtd = false;
      settings.ValidationType = ValidationType.DTD;
      settings.ValidationEventHandler += new ValidationEventHandler(ValidationCallBack);
      
      XmlReader xmlReader = XmlReader.Create(filePath, settings);
      while (xmlReader.Read()) ;
      xmlReader.Close();
      Console.WriteLine("유효한 문서");
    }
  }
}
