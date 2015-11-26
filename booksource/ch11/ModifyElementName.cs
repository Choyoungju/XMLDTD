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

      XmlElement eNewBook = xmlDocument.CreateElement("å");
      //�Ӽ� ����
      foreach (XmlAttribute xmlAttribute in eOldBook.Attributes)
      {
        eNewBook.SetAttribute(xmlAttribute.Name, xmlAttribute.Value);
      }
      //���� ��� ������ ���̱�
      foreach (XmlElement eChild in eOldBook.ChildNodes)
      {
        eNewBook.AppendChild(eChild.CloneNode(true));
      }

      //���� ���� ��带 �� ���� ���� ��ü
      eBooklist.ReplaceChild(eNewBook, eOldBook);

      StringWriter stringWriter = new StringWriter();
      xmlDocument.Save(stringWriter);
      Console.WriteLine(stringWriter.ToString());
    }
  }
}
