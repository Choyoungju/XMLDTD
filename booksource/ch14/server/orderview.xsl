<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:template match="/">
        <response>
            <xsl:copy-of select="/orders"/>            
        </response>        
    </xsl:template>

</xsl:stylesheet>