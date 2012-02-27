package cz.jirimasek.dppnews.api.v1.entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jiří Mašek <masekji4@fit.cvut.cz>
 */
@XmlRootElement
public class RDFModeOfTransport
{

    private final String BUS = "Bus";
    private final String TRAM = "Tram";
    private final String SUBWAY = "Subway";
    private final String FUNICULAR = "Funicular";
    private final String FERRY = "Ferry";
    private String resource;

    public RDFModeOfTransport()
    {
        this.resource = null;
    }

    public RDFModeOfTransport(int line, String type)
    {
        if (type != null && !type.isEmpty())
        {
            if (type.toUpperCase().contains("BUS"))
            {
                type = BUS;
            }
            else if (type.toUpperCase().contains("TRAM"))
            {
                type = TRAM;
            }
            else if (type.toUpperCase().contains("METRO"))
            {
                type = SUBWAY;
            }
            else if (type.contains("Lanová dráha"))
            {
                type = FUNICULAR;
            }
        }

        String mot;

        if (line > 990)
        {
            mot = SUBWAY;
        }
        else if (line > 800)
        {
            mot = type;
        }
        else if (line > 690)
        {
            mot = FERRY;
        }
        else if (line == 99)
        {
            mot = FUNICULAR;
        }
        else if (line < 99)
        {
            mot = TRAM;
        }
        else
        {
            mot = BUS;
        }

        this.resource = RDF.XMLNS_PUBTRANS + mot;
    }

    @XmlAttribute(name = "rdf:resource")
    public String getResource()
    {
        return resource;
    }

    public void setResource(String resource)
    {
        this.resource = resource;
    }
}
