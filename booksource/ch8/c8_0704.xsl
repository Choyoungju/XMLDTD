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
						<th>author</th>
					</tr>

					<!-- book 템플레이트 룰 적용 -->
					<xsl:apply-templates select="/booklist/book[@kind='computer']"
					                     mode="modeA"/>
					<xsl:apply-templates select="/booklist/book[@kind='잡지']"
					                     mode="modeB"/>
				</table>
			</body>
		</html>
	</xsl:template>

	<!-- book 템플레이트 룰 -->
	<xsl:template match="book" mode="modeA">
		<tr>
			<td><xsl:value-of select="title"/></td>
			<td><xsl:value-of select="author"/></td>
		</tr>
	</xsl:template>

	<xsl:template match="book" mode="modeB">
		<tr>
			<td>
				<font color="red"><xsl:value-of select="title"/></font>
			</td>
			<td>
				<font color="green"><xsl:value-of select="title"/></font>
			</td>
		</tr>
	</xsl:template>

</xsl:stylesheet>
