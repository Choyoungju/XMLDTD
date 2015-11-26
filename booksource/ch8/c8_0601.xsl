<?xml version="1.0" encoding="euc-kr"?>
<xsl:stylesheet version="1.0"
	              xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<!-- Result Tree를 XML 문서 종류로 생성 -->
	<xsl:output method="xml" version="1.0" encoding="euc-kr" indent="yes"/>

	<!-- Result Tree의 엘리먼트 내용 작성 -->
	<xsl:template match="/">
		<책목록>
			<책>
				<xsl:value-of select="/booklist/book"/>
			</책>
		</책목록>
	</xsl:template>

 
</xsl:stylesheet>
