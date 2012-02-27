package cz.jirimasek.dppnews.api.v2.entities;

import com.google.appengine.api.datastore.Key;
import cz.jirimasek.dppnews.dao.entities.Event;
import cz.jirimasek.dppnews.dao.entities.Incident;
import cz.jirimasek.dppnews.dao.entities.Transportation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Třída <code>JSONFactory</code>
 * 
 * @author Jiří Mašek <email@jirimasek.cz>
 */
public class JSONFactory
{

    private final String ABOUT_PREFIX = "http://www.dpp.cz/mimoradne-udalosti/";
    
    private final String BUS = "Bus";
    private final String TRAM = "Tram";
    private final String SUBWAY = "Subway";
    private final String FUNICULAR = "Funicular";
    private final String FERRY = "Ferry";

    /**
     * 
     * @param incident
     * @param events
     * @param transportations
     * @return 
     */
    public JSONIncident createIncident(Incident incident,
            Map<Key, Event> events,
            Map<Key, Transportation> transportations)
    {
        JSONIncident i = new JSONIncident();

        i.setAbout(ABOUT_PREFIX + incident.getKey().getName());
        
        i.setStretch(incident.getStretch());
        i.setOrigin(incident.getOrigin());
        i.setAssumption(incident.getAssumption());
        i.setRenew(incident.getRenew());
        i.setEvents(createEvents(incident, events));
        i.setLines(createLines(incident, transportations));

        return i;
    }

    /**
     * 
     * @param incident
     * @param events
     * @return 
     */
    public List<String> createEvents(Incident incident, Map<Key, Event> events)
    {
        List<String> output = new ArrayList<String>();
        
        for (Key key : incident.getEvents())
        {
            output.add(events.get(key).getType());
        }
        
        return output;
    }

    /**
     * 
     * @param incident
     * @param transportations
     * @return 
     */
    public List<JSONLine> createLines(Incident incident,
            Map<Key, Transportation> transportations)
    {
        String lines = incident.getLines();
        List<Key> transports = incident.getTransportations();

        if (lines != null && !lines.isEmpty())
        {
            List<JSONLine> output = new ArrayList<JSONLine>();

            for (String line : parseLines(lines))
            {

                String t = null;

                if (transports != null && !transports.isEmpty())
                {
                    t = transportations.get(transports.get(0)).getType();
                }

                Integer lineNumber = convertLineNumber(line, t);
                String transport = assignTransport(lineNumber, t);

                JSONLine l = new JSONLine();

                l.setNumber(line);
                l.setTransport(transport);

                output.add(l);
            }

            return output;
        }

        return null;
    }

    /**
     * 
     * @param lines
     * @return 
     */
    private String[] parseLines(String lines)
    {
        lines = lines.replaceAll("\\s+a\\s+", ", ");
        lines = lines.replaceAll("\\s?\\.\\s?", ", ");
        lines = lines.replaceAll("\\s+-\\s+zpoždění do\\s+[0-9]+\\s+minut", "");
        lines = lines.replaceAll("odklon linky", "");
        lines = lines.trim();

        String[] output = lines.split(",\\s*");

        return output;
    }

    /**
     * 
     * @param line
     * @param transport
     * @return 
     */
    private Integer convertLineNumber(String line, String transport)
    {
        if (line != null && !line.isEmpty())
        {
            line = line.trim();
            
            line = line.equals("A") ? "991" : line;
            line = line.equals("B") ? "992" : line;
            line = line.equals("C") ? "993" : line;
            line = line.contains("X") ? line.length() > 2 ? line.replaceAll("X",
                    "8") : line.replaceAll("X", "80") : line;
            line = line.contains("P") ? line.replaceAll("P", "69") : line;

            return new Integer(line);
        }
        else if (transport != null)
        {
            if (transport.contains("linka A"))
            {
                return new Integer(991);
            }
            else if (transport.contains("linka B"))
            {
                return new Integer(992);
            }
            else if (transport.contains("linka C"))
            {
                return new Integer(993);
            }
            else if (transport.equals("Lanová dráha"))
            {
                return new Integer(99);
            }
        }

        return null;
    }

    /**
     * 
     * @param line
     * @param transport
     * @return 
     */
    private String assignTransport(Integer line, String transport)
    {
        if (transport != null && !transport.isEmpty())
        {
            if (transport.toUpperCase().contains("BUS"))
            {
                return BUS;
            }
            else if (transport.toUpperCase().contains("TRAM"))
            {
                return TRAM;
            }
            else if (transport.toUpperCase().contains("METRO"))
            {
                return SUBWAY;
            }
            else if (transport.contains("Lanová dráha"))
            {
                return FUNICULAR;
            }
        }
        
        if (line != null)
        {

            if (line.intValue() > 990)
            {
                return SUBWAY;
            }
            else if (line.intValue() > 800)
            {
                return transport;
            }
            else if (line.intValue() > 690)
            {
                return FERRY;
            }
            else if (line.intValue() == 99)
            {
                return FUNICULAR;
            }
            else if (line.intValue() < 99)
            {
                return TRAM;
            }
        }
        
        return BUS;
    }
}
