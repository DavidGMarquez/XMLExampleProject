<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes" />

<xsl:template match="/">
   <html>
   <table border="1">
      <th>Autor</th>
      <th>Titulo</th>
      <th>Precio</th>
      <xsl:for-each select="Biblioteca/libro">
      <xsl:sort select="@categoria" />
            <tr>
            <td><i><xsl:value-of select="autor" /></i></td>
            <td><xsl:value-of select="titulo" /></td>
            <td><xsl:value-of select="precio" /></td>
            </tr>
      </xsl:for-each>
   </table>
   </html>
</xsl:template>

</xsl:stylesheet>