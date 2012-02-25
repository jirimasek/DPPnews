package cz.jirimasek.dppnews.api.v1.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 *
 * @author Jiří Mašek <masekji4@fit.cvut.cz>
 */
@XmlRootElement
public class RDFDatetime
{
    private final String XSD_DATETIME = "http://www.w3.org/2001/XMLSchema#dateTime";
    
    private String value;
    private String datatype;

    public RDFDatetime()
    {
        this.value = null;
        this.datatype = null;
    }
            
    public RDFDatetime(Date date)
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        
        this.value = df.format(date);
        this.datatype = XSD_DATETIME;
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
