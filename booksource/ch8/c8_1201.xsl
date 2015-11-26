<?xml version="1.0" encoding="euc-kr"?>
<xsl:stylesheet version="1.0"
	              xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<!-- 글로벌 변수 선언 -->
	<xsl:variable name="vList" select="'책목록'"/>
	<xsl:variable name="vKind">computer</xsl:variable>
	<xsl:variable name="vSize" select="10"/>
	<xsl:variable name="vCompany">
		<font color="blue">민철 소프트</font> 주식회사
	</xsl:variable>

  <!-- 시작 템플레이트 룰 -->
	<xsl:template match="/">
		<html>
			<body>
				<!-- 컨텐트 내용으로 사용 -->
				<h2> <xsl:value-of select="$vList"/> </h2>
				
				<!-- XPath 표현식에서 사용 -->
				<xsl:for-each select="//book[@kind=$vKind]">

					<!-- 속성값으로 사용 -->
					<font size="{$vSize}">
						<xsl:value-of select="title"/>
					</font>
					<br/>
				</xsl:for-each>

				<br/><br/>

				<!-- 엘리먼트를 포함하고 있는 변수 사용 -->
			  <xsl:copy-of select="$vCompany"/>

			</body>
		</html>
	</xsl:template>

</xsl:stylesheet>
