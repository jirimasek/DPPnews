package cz.jirimasek.dppnews.api.v1.entities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jiří Mašek <masekji4@fit.cvut.cz>
 */
@XmlRootElement(name = "rdf:RDF")
public class RDF
{
    private final String XMLNS_RDFS = "http://www.w3.org/2000/01/rdf-schema#";
    private final String XMLNS_OWL2XML = "http://www.w3.org/2006/12/owl2-xml#";
    private final String XMLNS_OWL = "http://www.w3.org/2002/07/owl#";
    private final String XMLNS_XSD = "http://www.w3.org/2001/XMLSchema#";
    private final String XMLNS_RDF = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
    private final String XMLNS_ATOM = "http://www.w3.org/2005/Atom";
    
    public static final String XMLNS_PUBTRANS = "http://dpp-news.appspot.com/vocab/public-transport#";
    
    private List<RDFIncident> incidents;
    
    public RDF()
    {
        this.incidents = null;
    }
    
    @XmlAttribute(name = "xmlns:rdfs")
    public String getXmlnsRdfs()
    {
        return XMLNS_RDFS;
    }
    
    @XmlAttribute(name = "xmlns:owl2xml")
    public String getXmlnsOwl2Xml()
    {
        return XMLNS_OWL2XML;
    }
    
    @XmlAttribute(name = "xmlns:owl")
    public String getXmlnsOwl()
    {
        return XMLNS_OWL;
    }
    
    @XmlAttribute(name = "xmlns:xsd")
    public String getXmlnsXsd()
    {
        return XMLNS_XSD;
    }
    
    @XmlAttribute(name = "xmlns:rdf")
    public String getXmlnsRdf()
    {
        return XMLNS_RDF;
    }
    
    @XmlAttribute(name = "xmlns:pubtrans")
    public String getXmlnsPubtrans()
    {
        return XMLNS_PUBTRANS;
    }
    
    @XmlAttribute(name = "xmlns:atom")
    public String getXmlnsAtom()
    {
        return XMLNS_ATOM;
    }

    @XmlElements({
        @XmlElement(name = "pubtrans:Incident", type = RDFIncident.class)
    })
    public List<RDFIncident> getIncidents()
    {
        return incidents;
    }

    public void setIncidents(List<RDFIncident> persons)
    {
        this.incidents = persons;
    }

    public void addIncident(RDFIncident foafPerson)
    {
        if (incidents == null)
        {
            incidents = new ArrayList<RDFIncident>();
        }
        
        incidents.add(foafPerson);
    }
}
