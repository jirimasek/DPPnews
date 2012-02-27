package cz.jirimasek.dppnews.api.v2.entities;

import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Třída <code>JSONIncident</code>
 *
 * @author Jiří Mašek <email@jirimasek.cz>
 */
@XmlRootElement(name = "incidents")
public class JSONIncident
{
    
    private String about;
    private String stretch;
    private Date origin;
    private Date assumption;
    private Date renew;
    private List<JSONLine> lines;
    private List<String> events;

    public JSONIncident()
    {
        this.about = null;
        this.stretch = null;
        this.origin = null;
        this.assumption = null;
        this.renew = null;
        this.lines = null;
        this.events = null;
    }

    public String getAbout()
    {
        return about;
    }

    public void setAbout(String about)
    {
        this.about = about;
    }

    public String getStretch()
    {
        return stretch;
    }

    public void setStretch(String stretch)
    {
        this.stretch = stretch;
    }

    public Date getOrigin()
    {
        return origin;
    }

    public void setOrigin(Date origin)
    {
        this.origin = origin;
    }

    public Date getAssumption()
    {
        return assumption;
    }

    public void setAssumption(Date assumption)
    {
        this.assumption = assumption;
    }

    public Date getRenew()
    {
        return renew;
    }

    public void setRenew(Date renew)
    {
        this.renew = renew;
    }

    public List<JSONLine> getLines()
    {
        return lines;
    }

    public void setLines(List<JSONLine> lines)
    {
        this.lines = lines;
    }

    public List<String> getEvents()
    {
        return events;
    }

    public void setEvents(List<String> events)
    {
        this.events = events;
    }
    
    
}
