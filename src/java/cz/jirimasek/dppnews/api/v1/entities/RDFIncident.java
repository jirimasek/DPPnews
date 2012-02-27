package cz.jirimasek.dppnews.api.v1.entities;

import com.google.appengine.api.datastore.Key;
import cz.jirimasek.dppnews.dao.entities.Event;
import cz.jirimasek.dppnews.dao.entities.Incident;
import cz.jirimasek.dppnews.dao.entities.Transportation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Třída <code>RDFIncident</code>
 * 
 * @author Jiří Mašek <email@jirimasek.cz>
 */
@XmlRootElement
@XmlType(propOrder={"stretch", "origin", "lines", "events", "assumption", "renew"})
public class RDFIncident
{

    private final String ABOUT_PREFIX = "http://www.dpp.cz/mimoradne-udalosti/";
    
    private String about;
    private RDFStretch stretch;
    private RDFDatetime origin;
    private RDFDatetime assumption;
    private RDFDatetime renew;
    private List<RDFAffectsLine> lines;
    private List<RDFEvent> events;

    public RDFIncident()
    {
        this.about = null;
        this.stretch = null;
        this.origin = null;
        this.assumption = null;
        this.renew = null;
        this.lines = null;
        this.events = null;
    }

    public RDFIncident(Incident incident,
            Map<Key, Event> events,
            Map<Key, Transportation> transportations)
    {
        init(incident, events, transportations);
    }
    
    private void init(Incident incident,
            Map<Key, Event> events,
            Map<Key, Transportation> transportations)
    {
        this.about = ABOUT_PREFIX + incident.getKey().getName();
        this.stretch = incident.getStretch() != null ? new RDFStretch(incident.getStretch()) : null;
        this.origin = incident.getOrigin() != null ? new RDFDatetime(incident.getOrigin()) : null;
        this.assumption = incident.getAssumption() != null ? new RDFDatetime(incident.getAssumption()) : null;
        this.renew = incident.getRenew() != null ? new RDFDatetime(incident.getRenew()) : null;

        initLines(incident, transportations);
        initEvents(incident, events);
    }

    private void initLines(Incident incident,
            Map<Key, Transportation> transportations)
    {
        if (incident.getLines() != null)
        {
            String l1;

            l1 = incident.getLines();
            l1 = l1.replaceAll("\\s+a\\s+", ", ");
            l1 = l1.replaceAll("\\s+-\\s+zpoždění do\\s+[0-9]+\\s+minut", "");
            l1 = l1.replaceAll("odklon linky", "");
            l1 = l1.trim();

            String[] l2 = l1.split(",\\s*");

            this.lines = new ArrayList<RDFAffectsLine>();

            for (String line : l2)
            {
                String modeOfTransportation = null;
                
                if (incident.getTransportations() != null
                        && !incident.getTransportations().isEmpty())
                {
                    modeOfTransportation = transportations.get(incident.getTransportations().get(0)).getType();
                }
                
                this.lines.add(new RDFAffectsLine(line, modeOfTransportation));
            }
        }
        else
        {
            String modeOfTransportation = null;
                
            if (incident.getTransportations() != null
                    && !incident.getTransportations().isEmpty())
            {
                modeOfTransportation = transportations.get(incident.getTransportations().get(0)).getType();
                
                this.lines = new ArrayList<RDFAffectsLine>();
                
                this.lines.add(new RDFAffectsLine(null, modeOfTransportation));
            }
            else
            {
                this.lines = null;
            }
        }
    }

    private void initEvents(Incident incident,
            Map<Key, Event> events)
    {
        if (incident.getEvents() != null)
        {

            this.events = new ArrayList<RDFEvent>();

            for (Key key : incident.getEvents())
            {
                Event event = events.get(key);
                
                this.events.add(new RDFEvent(event.getType()));
            }
        }
        else
        {
            this.events = null;
        }
    }
    
    @XmlAttribute(name = "rdf:about")
    public String getAbout()
    {
        return about;
    }

    public void setAbout(String about)
    {
        this.about = about;
    }

    @XmlElement(name = "pubtrans:stretch")
    public RDFStretch getStretch()
    {
        return stretch;
    }

    public void setStretch(RDFStretch stretch)
    {
        this.stretch = stretch;
    }

    @XmlElement(name = "pubtrans:originatedAt")
    public RDFDatetime getOrigin()
    {
        return origin;
    }

    public void setOrigin(RDFDatetime origin)
    {
        this.origin = origin;
    }

    @XmlElement(name = "pubtrans:isExpectedToBeSolvedAt")
    public RDFDatetime getAssumption()
    {
        return assumption;
    }

    public void setAssumption(RDFDatetime assumption)
    {
        this.assumption = assumption;
    }

    @XmlElement(name = "pubtrans:wasSolvedAt")
    public RDFDatetime getRenew()
    {
        return renew;
    }

    public void setRenew(RDFDatetime renew)
    {
        this.renew = renew;
    }

    @XmlElements(
    {
        @XmlElement(name = "pubtrans:affectsLine", type = RDFAffectsLine.class)
    })
    public List<RDFAffectsLine> getLines()
    {
        return lines;
    }

    public void setLines(List<RDFAffectsLine> lines)
    {
        this.lines = lines;
    }

    @XmlElements(
    {
        @XmlElement(name = "pubtrans:type", type = RDFEvent.class)
    })
    public List<RDFEvent> getEvents()
    {
        return events;
    }

    public void setEvents(List<RDFEvent> events)
    {
        this.events = events;
    }
}
