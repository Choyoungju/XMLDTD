using System;
using System.Xml;
using System.Xml.Xsl;
using System.Diagnostics;

namespace booksource.ch12
{
  class Transformation
	{
		static void Main()
		{
      //XSLT 문서 지정
      string xslFilePath = @"..\..\ch12\booklist.xsl";
      XslCompiledTransform transformer = new XslCompiledTransform();
      transformer.Load(xslFilePath);
			
      //원본 XML 문서 지정
      string xmlFilePath = @"..\..\ch12\booklist.xml";
      XmlReader xmlReader = XmlReader.Create(xmlFilePath);
      
      //출력 형태 지정
      string resultFilePath = @"C:\Temp\result.htm";
      XmlWriter xmlWriter = XmlWriter.Create(resultFilePath);

      //변환하기
      transformer.Transform(xmlReader, xmlWriter);

      //인터넷 익스플로러 실행
      Process.Start("IExplore.exe", @"C:\Temp\result.htm");
		}
	}
}
