<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0"  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
		<html>
			<body>				
				<h1>책목록</h1>				
				<table border="1" cellspacing="0" width="80%">
					<tr bgcolor="yellow">						
						<th>제목</th>						
						<th>저자</th>						
						<th>출판자</th>						
						<th>가격</th>					
					</tr>					
					<xsl:apply-templates select="//book"/>
				</table>
			</body>
		</html>	
	</xsl:template>
	
	<xsl:template match="book">
		<tr align="center">						
			<td><xsl:value-of select="./title" /></td>
			<td><xsl:value-of select="./author" /></td>
			<td><xsl:value-of select="./publisher" /></td>
			<td><xsl:value-of select="./price" /></td>		
		</tr>
	</xsl:template>
	
 </xsl:stylesheet>

  