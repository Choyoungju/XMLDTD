<?xml version="1.0" encoding="euc-kr"?>
<xsl:stylesheet version="1.0"
	              xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
		<html>
			<body>
				<h2><font color="blue">Our Book's List</font></h2>
				<table border="1" cellspacing="0" width="80%">
					<tr bgcolor="#FFFF66">
						<th>title</th>
						<th>author</th>
						<th>publisher</th>
						<th>price</th>
					</tr>
					<xsl:apply-templates select="/booklist/book"/>
				</table>
			</body>
		</html>
	</xsl:template>

	<xsl:template match="book">
		<tr>
			<td><xsl:value-of select="title"/></td>
			<td><xsl:value-of select="author"/></td>
			<td><xsl:value-of select="publisher"/></td>
			<td><xsl:value-of select="price"/></td>
		</tr>
	</xsl:template>


</xsl:stylesheet>
