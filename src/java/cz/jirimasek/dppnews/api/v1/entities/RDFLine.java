package cz.jirimasek.dppnews.api.v1.entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jiří Mašek <masekji4@fit.cvut.cz>
 */
@XmlRootElement
public class RDFLine
{

    private final String LINE_PREFIX = "http://jrportal.dpp.cz/jrportal/LineList.aspx?lc=";
    private String about;
    private RDFNumber number;
    private RDFModeOfTransport modeOfTransport;

    public RDFLine()
    {
        this.about = null;
        this.number = null;
        this.modeOfTransport = null;
    }

    public RDFLine(String line, String modeOfTrasportation)
    {
        init(line, modeOfTrasportation);
    }
    
    private void init(String line, String modeOfTrasportation)
    {
        if (line != null && !line.isEmpty())
        {
            this.number = new RDFNumber(line);

            line = line.equals("A") ? "991" : line;
            line = line.equals("B") ? "992" : line;
            line = line.equals("C") ? "993" : line;
            line = line.contains("X") ? line.length() > 2 ? line.replaceAll("X", "8") : line.replaceAll("X", "80") : line;
            line = line.contains("P") ? line.replaceAll("P", "69") : line;
        }
        else if (modeOfTrasportation != null)
        {
            if (modeOfTrasportation.contains("linka A"))
            {
                this.number = new RDFNumber("A");
                
                line = "991";
            }
            else if (modeOfTrasportation.contains("linka B"))
            {
                this.number = new RDFNumber("B");
                
                line = "992";
            }
            else if (modeOfTrasportation.contains("linka C"))
            {
                this.number = new RDFNumber("C");
                
                line = "993";
            }
            else if (modeOfTrasportation.equals("Lanová dráha"))
            {
                this.number = new RDFNumber("LD");
                
                line = "99";
            }
        }
        
        if (line != null)
        {
            this.about = LINE_PREFIX + line;

            try
            {
                int l = Integer.parseInt(line);

                this.modeOfTransport = new RDFModeOfTransport(l, modeOfTrasportation);
            }
            catch (NumberFormatException ex)
            {
                this.modeOfTransport = null;
            }
        }
        else
        {
            this.about = null;
            this.number = null;
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

    @XmlElement(name = "pubtrans:number")
    public RDFNumber getNumber()
    {
        return number;
    }

    public void setNumber(RDFNumber number)
    {
        this.number = number;
    }

    @XmlElement(name = "pubtrans:modeOfTransport")
    public RDFModeOfTransport getModeOfTransport()
    {
        return modeOfTransport;
    }

    public void setModeOfTransport(RDFModeOfTransport modeOfTransport)
    {
        this.modeOfTransport = modeOfTransport;
    }
}
