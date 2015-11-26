<?xml version="1.0" encoding="euc-kr"?>
<xsl:stylesheet version="1.0"
	             xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<!-- html 방식으로 출력한다. -->
<xsl:output method="html"/>

	<xsl:template match="/">
		<html>
			<body>
				<h1>Our Book's List</h1>
				<table border="1" cellspacing="0" width="80%">
					<tr>
						<th>제목</th>
						<th>저자</th>
						<th>출판자</th>
						<th>가격</th>
					</tr>
					<tr align="center">
						<td><xsl:value-of select="//book/title" /></td>
						<td><xsl:value-of select="//book/author" /></td>
						<td><xsl:value-of select="//book/publisher" /></td>
						<td><xsl:value-of select="//book/title" /></td>
					</tr>
				</table>
			</body>
		</html>
	</xsl:template>
 
</xsl:stylesheet>
