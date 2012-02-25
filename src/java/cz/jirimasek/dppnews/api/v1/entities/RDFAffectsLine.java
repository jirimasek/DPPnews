package cz.jirimasek.dppnews.api.v1.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jiří Mašek <masekji4@fit.cvut.cz>
 */
@XmlRootElement
public class RDFAffectsLine
{
    private RDFLine line;

    public RDFAffectsLine()
    {
    }

    public RDFAffectsLine(String line, String modeOfTrasportation)
    {
        this.line = new RDFLine(line, modeOfTrasportation);
    }

    @XmlElement(name = "pubtrans:Line")
    public RDFLine getLine()
    {
        return line;
    }

    public void setLine(RDFLine line)
    {
        this.line = line;
    }
}
