<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:template match="/">
        <html>
            <head>
                <title>주문 내용</title>
            </head>
            <body>
                <b>주문내용</b>
                <hr/>
                <table border="1" cellpadding="0">
                    <tr bgcolor="yellow">
                        <th>주문자</th>
                        <th>주문자명</th>
                        <th>상품아이디</th>
                        <th>상품명</th>
                        <th>주문량</th>
                    </tr>
                    <xsl:apply-templates select="/response/orders/order"/>
                </table>                
            </body>            
        </html>        
    </xsl:template>
    
    <xsl:template match="order">
        <tr>
            <td><xsl:value-of select="userid"/></td>
            <td><xsl:value-of select="username"/></td>
            <td><xsl:value-of select="productid"/></td>
            <td><xsl:value-of select="productname"/></td>
            <td><xsl:value-of select="qty"/></td>
        </tr>
    </xsl:template>

</xsl:stylesheet>