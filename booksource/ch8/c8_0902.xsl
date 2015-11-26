<?xml version="1.0" encoding="euc-kr"?>
<xsl:stylesheet version="1.0"
	              xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <!-- 시작 템플레이트 룰 -->
	<xsl:template match="/">
		<html>
			<body>
				<h2><font color="blue">Our Book's List</font></h2>
				<table border="1" cellspacing="0" width="80%">
					<tr bgcolor="#FFFF66">
						<th>title</th>
						<th>kind</th>
						<th>price</th>
					</tr>

					<!-- book 템플레이트 룰 적용 -->
					<xsl:apply-templates select="/booklist/book">
						<!-- 1차 정렬 -->
						<xsl:sort select="@kind"/>
						<!-- 2차 정렬 -->
						<xsl:sort select="price" 
											data-type="number" order="ascending"/>
					</xsl:apply-templates>

				</table>
			</body>
		</html>
	</xsl:template>

	<!-- book 템플레이트 룰 -->
	<xsl:template match="book">
		<tr>
			<td><xsl:value-of select="title"/></td>
			<td><xsl:value-of select="@kind"/></td>
			<td><xsl:value-of select="price"/></td>
		</tr>
	</xsl:template>

</xsl:stylesheet>
