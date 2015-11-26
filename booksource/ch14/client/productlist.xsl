<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:template match="/">
        <html>
            <head>
                <title>상품 목록</title>
            </head>
            <body>
                <b>상품목록</b>
                <hr/>
                <table border="1" cellpadding="0">
                    <tr bgcolor="yellow">
                        <th>상품아이디</th>
                        <th>상품명</th>
                        <th>상품가격</th>
                    </tr>
                    <xsl:apply-templates select="/response/products/product"/>
                </table>                
            </body>            
        </html>        
    </xsl:template>
    
    <xsl:template match="product">
        <tr>
            <td><xsl:value-of select="productid"/></td>
            <td><xsl:value-of select="productname"/></td>
            <td><xsl:value-of select="productprice"/></td>
        </tr>
    </xsl:template>

</xsl:stylesheet>