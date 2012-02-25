package cz.jirimasek.dppnews.api.v1.entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 *
 * @author Jiří Mašek <masekji4@fit.cvut.cz>
 */
@XmlRootElement
public class RDFStretch
{
    private final String XSD_STRING = "http://www.w3.org/2001/XMLSchema#string";
    
    private String value;
    private String datatype;

    public RDFStretch()
    {
        this.value = null;
        this.datatype = null;
    }
            
    public RDFStretch(String stretch)
    {
        this.value = stretch;
        this.datatype = XSD_STRING;
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
