using System;
using System.Xml;
using System.IO;

namespace booksource.ch11
{
  class ModifyElementName
  {
    static void Main()
    {
      string filePath = @"..\..\ch11\booklist.xml";
      XmlDocument xmlDocument = new XmlDocument();
      xmlDocument.Load(filePath);

      XmlElement eBooklist = xmlDocument.DocumentElement;

      XmlElement eOldBook = (XmlElement)eBooklist.LastChild;

      XmlElement eNewBook = xmlDocument.CreateElement("책");
      //속성 복사
      foreach (XmlAttribute xmlAttribute in eOldBook.Attributes)
      {
        eNewBook.SetAttribute(xmlAttribute.Name, xmlAttribute.Value);
      }
      //하위 노드 복제와 붙이기
      foreach (XmlElement eChild in eOldBook.ChildNodes)
      {
        eNewBook.AppendChild(eChild.CloneNode(true));
      }

      //기존 하위 노드를 새 하위 노드로 교체
      eBooklist.ReplaceChild(eNewBook, eOldBook);

      StringWriter stringWriter = new StringWriter();
      xmlDocument.Save(stringWriter);
      Console.WriteLine(stringWriter.ToString());
    }
  }
}
