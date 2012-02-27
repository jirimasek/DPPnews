package cz.jirimasek.dppnews.api.v2.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Třída <code>JSONLine</code>
 * 
 * @author Jiří Mašek <email@jirimasek.cz>
 */
@XmlRootElement
@XmlType(propOrder={"number", "transport"})
public class JSONLine
{
    private String number;
    private String transport;

    public JSONLine()
    {
    }

    @XmlElement(name = "number")
    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    @XmlElement(name = "transport")
    public String getTransport()
    {
        return transport;
    }

    public void setTransport(String transport)
    {
        this.transport = transport;
    }
    
}
