package cz.jirimasek.dppnews.source;

import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Parser
{

    public Document parse(String html) throws SAXException, IOException,
            ParserConfigurationException
    {
        html = html.replaceAll("&([^\\s])*=", "&amp;$1=");
        html = html.replaceAll("</wdf:if>\\s+</p>\\s+</p>", "</p>");
        html = html.replaceAll("</wdf:if>", "");
        html = html.replaceAll("</span>\\s+</p>\\s+</p>\\s+<span class=\"clear\">", "</span></p><span class=\"clear\">");
        html = html.replaceAll("</strong></span>\\s+</p>\\s+</p>\\s+<p>Čas", "</strong></span></p><p>Čas");
        html = html.replaceAll("</strong>\\s+</p>\\s+</p>\\s+<span class=\"clear\">", "</strong></p><span class=\"clear\">"); 
        
        // Step 1: create a DocumentBuilderFactory

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(html));

        // Step 2: create a DocumentBuilder

        DocumentBuilder db = dbf.newDocumentBuilder();

        db.setEntityResolver(new EntityResolver()
        {
            @Override
            public InputSource resolveEntity(String publicId, String systemId)
                    throws SAXException, IOException
            {
                if (systemId.contains("xhtml1-strict.dtd"))
                {
                    return new InputSource(new StringReader(""));
                }
                else
                {
                    return null;
                }
            }
        });

        // Step 3: parse the input file to get a Document object
        try
        {
            return db.parse(is);
        }
        catch (SAXException ex)
        {
            Logger.getLogger(Parser.class.getName()).
                        log(Level.SEVERE, html, ex);
            
            throw ex;
        }
    }

}
