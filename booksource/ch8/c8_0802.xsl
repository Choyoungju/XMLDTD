<?xml version="1.0" encoding="euc-kr"?>
<xsl:stylesheet version="1.0"
	              xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<!-- Result Tree를 XML 문서 종류로 생성 -->
	<xsl:output method="xml" version="1.0" encoding="euc-kr" indent="yes"/>

  <!-- 시작 템플레이트 룰 -->
	<xsl:template match="/">
		<책목록>
			<xsl:apply-templates select="/booklist/book"/>
		</책목록>
	</xsl:template>

	<!-- book 템플레이트 룰 -->
	<xsl:template match="book">
		<책>
			<xsl:copy-of select="@id"/>
			<xsl:copy-of select="@kind"/>
			<xsl:copy-of select="title"/>
			<xsl:copy-of select="author"/>
			<xsl:copy-of select="publisher"/>
			<xsl:copy-of select="price"/>
		</책>
	</xsl:template>

</xsl:stylesheet>
