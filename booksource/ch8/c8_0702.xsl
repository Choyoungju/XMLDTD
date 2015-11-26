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
					<xsl:apply-templates select="/booklist/book[@kind='computer']"/>

				</table>
				
				<br/><hr align="left" width="80%"/>

				<!-- name 속성을 갖는 템플레이트 룰 적용 -->
				<xsl:call-template name="tCompany"/>

			</body>
		</html>
	</xsl:template>

	<!-- book 템플레이트 룰 -->
	<xsl:template match="book">
		<tr>
			<td><xsl:value-of select="title"/></td>
			<td><xsl:value-of select="author"/></td>
		</tr>
	</xsl:template>

	<!-- name 속성을 갖는 템플레이트 룰 -->
	<xsl:template name="tCompany">
		<font color="blue">민철 소프트웨어</font> 주식회사 
		- 서울시 역삼동
	</xsl:template>

</xsl:stylesheet>
