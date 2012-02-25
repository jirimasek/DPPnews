package cz.jirimasek.dppnews.dao.entities;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import cz.jirimasek.dppnews.dao.EventDAO;
import cz.jirimasek.dppnews.dao.IEventDAO;
import cz.jirimasek.dppnews.dao.ITransportationDAO;
import cz.jirimasek.dppnews.dao.TransportationDAO;
import cz.jirimasek.dppnews.source.DataSource;
import java.text.SimpleDateFormat;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Incident
{

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;
    @Persistent
    private String stretch;
    @Persistent
    private Date origin;
    @Persistent
    private Date assumption;
    @Persistent
    private Date renew;
    @Persistent
    private String lines;
    @Persistent
    private List<Key> events;
    @Persistent
    private List<Key> transportations;

    public Incident()
    {
        this.key = null;
        this.stretch = null;
        this.origin = null;
        this.assumption = null;
        this.renew = null;
        this.events = null;
        this.transportations = null;
    }

    public Incident(Key key, String stretch, Date origin, Date assumption,
            Date renew, String lines, List<Key> events,
            List<Key> transportations)
    {
        this.key = key;
        this.stretch = stretch;
        this.origin = origin;
        this.assumption = assumption;
        this.renew = renew;
        this.lines = lines;
        this.events = events;
        this.transportations = transportations;
    }

    public Key getKey()
    {
        return key;
    }

    public void setKey(Key key)
    {
        this.key = key;
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

    public String getLines()
    {
        return lines;
    }

    public void setLines(String lines)
    {
        this.lines = lines;
    }

    public List<Key> getEvents()
    {
        return events;
    }

    public void setEvents(List<Key> events)
    {
        this.events = events;
    }

    public List<Key> getTransportations()
    {
        return transportations;
    }

    public void setTransportations(List<Key> transportations)
    {
        this.transportations = transportations;
    }

    public boolean isRenewed()
    {
        return this.renew != null;
    }

    @Override
    public String toString()
    {
        IEventDAO edao = new EventDAO();
        ITransportationDAO tdao = new TransportationDAO();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        String status = "";

        if (this.transportations != null && this.transportations.size() > 0)
        {
            Transportation transportation = tdao.get(this.transportations.get(0));

            status += "[" + transportation.getType().toUpperCase() + "] ";
        }

        status += this.stretch;

        if (this.events != null && this.events.size() > 0)
        {
            Event event = edao.get(this.events.get(0));

            status += " @ " + event.getType();
        }

        if (isRenewed())
        {
            status += " (provoz obnoven v " + sdf.format(this.renew) + ")";
        }
        else if (this.assumption != null)
        {
            status += " (předpokládané obnovení provozu v " + sdf.format(
                    this.assumption) + ")";
        }
        else if (this.origin != null)
        {
            status += " (vznik události v " + sdf.format(
                    this.origin) + ")";
        }

        if (status.length() > 120)
        {
            status = status.substring(0, 120);
        }


        status = status + " " + DataSource.DATA_URL + this.key.getName() + "/";

        return status;
    }
}
