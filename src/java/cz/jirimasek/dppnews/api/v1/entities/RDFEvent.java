package cz.jirimasek.dppnews.api.v1.entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * Třída <code>RDFEvent</code>
 *
 * @author Jiří Mašek <email@jirimasek.cz>
 */
@XmlRootElement
public class RDFEvent
{
    private final String XSD_STRING = "http://www.w3.org/2001/XMLSchema#string";
    
    private String datatype;
    private String value;

    public RDFEvent()
    {
        this.datatype = null;
        this.value = null;
    }
    
    public RDFEvent(String event)
    {
        this.datatype = XSD_STRING;
        this.value = event;
    }

    @XmlAttribute(name = "rdf:datatype")
    public String getDatatype()
    {
        return datatype;
    }

    public void setDatatype(String datatype)
    {
        this.datatype = datatype;
    }

    @XmlValue
    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }
}
