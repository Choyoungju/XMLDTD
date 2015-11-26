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
					<xsl:apply-templates select="/booklist/book"/>

				</table>

			</body>
		</html>
	</xsl:template>

  <!-- book 템플레이트 룰 -->
	<xsl:template match="book">
		<tr>
			<xsl:call-template name="tBook">
				<xsl:with-param name="pTitle" select="title"/>
			</xsl:call-template>
			<td><xsl:value-of select="author"/></td>
		</tr>
	</xsl:template>


	<xsl:template name="tBook">
		<xsl:param name="pTitle"/>
		<td>
			<font color="green" size="3">
				<b>
					<xsl:value-of select="$pTitle"/>
				</b>
			</font>	
		</td>
	</xsl:template>

</xsl:stylesheet>
