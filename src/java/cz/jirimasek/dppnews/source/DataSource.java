package cz.jirimasek.dppnews.source;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import cz.jirimasek.dppnews.dao.EventDAO;
import cz.jirimasek.dppnews.dao.IEventDAO;
import cz.jirimasek.dppnews.dao.ITransportationDAO;
import cz.jirimasek.dppnews.dao.TransportationDAO;
import cz.jirimasek.dppnews.dao.entities.Event;

import cz.jirimasek.dppnews.dao.entities.Incident;
import cz.jirimasek.dppnews.dao.entities.Transportation;
import java.text.SimpleDateFormat;

public class DataSource
{

    public static final String DATA_URL = "http://www.dpp.cz/mimoradne-udalosti/";

    private List<Incident> process(NodeList nodes)
    {
        List<Incident> incidents = new ArrayList<Incident>();

        for (int i = 0 ; i < nodes.getLength() ; i++)
        {
            Node node = nodes.item(i);

            if (node.getNodeName().equals("a"))
            {

                Incident incident = new Incident();

                String link = node.getAttributes().getNamedItem("href").
                        getTextContent();
                String id = link.substring(
                        link.lastIndexOf('/', link.length() - 2) + 1,
                        link.length() - 1);
                Key key = KeyFactory.createKey(Incident.class.getSimpleName(),
                        id);

                incident.setKey(key);

                incidents.add(incident);
            }
        }

        return incidents;
    }

    private Incident process(String id, NodeList stretch, NodeList origin,
            NodeList assumption, NodeList renew, NodeList lines, NodeList events,
            NodeList transportations)
    {

        IEventDAO edao = new EventDAO();
        ITransportationDAO tdao = new TransportationDAO();

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        Incident incident = new Incident();
        
        Key key = KeyFactory.createKey(Incident.class.getSimpleName(), id);
        
        incident.setKey(key);

        if (stretch != null && stretch.getLength() > 0)
        {
            incident.setStretch(stretch.item(0).getTextContent());
        }

        if (origin != null && origin.getLength() > 0)
        {
            try
            {
                incident.setOrigin(sdf.parse(origin.item(0).getTextContent()));
            }
            catch (ParseException ex)
            {
            }
        }

        if (assumption != null && assumption.getLength() > 0)
        {
            try
            {
                incident.setAssumption(sdf.parse(assumption.item(0).
                        getTextContent()));
            }
            catch (ParseException ex)
            {
            }
        }

        if (renew != null && renew.getLength() > 0)
        {
            try
            {
                incident.setRenew(sdf.parse(renew.item(0).getTextContent()));
            }
            catch (ParseException ex)
            {
            }
        }

        if (lines != null && lines.getLength() > 0)
        {
            incident.setLines(lines.item(0).getTextContent());
        }

        if (events != null && events.getLength() > 0)
        {
            List<Key> eList = new ArrayList<Key>();

            for (int i = 0 ; i < events.getLength() ; i++)
            {
                String event = events.item(i).getTextContent();

                Key k = KeyFactory.createKey(Event.class.getSimpleName(),
                        event);

                Event e = edao.get(k);

                if (e == null)
                {
                    e = new Event(k, event);
                    edao.save(e);
                }

                eList.add(k);
            }
            
            incident.setEvents(eList);
        }

        if (transportations != null && transportations.getLength() > 0)
        {
            List<Key> tList = new ArrayList<Key>();

            for (int i = 0 ; i < transportations.getLength() ; i++)
            {
                String transportation = transportations.item(i).getTextContent();

                Key k = KeyFactory.createKey(Transportation.class.getSimpleName(),
                        transportation);

                Transportation t = tdao.get(k);

                if (t == null)
                {
                    t = new Transportation(k, transportation);
                    
                    tdao.save(t);
                }

                tList.add(k);
            }
            
            incident.setTransportations(tList);
        }

        return incident;
    }

    public List<Incident> getIncidents() throws IOException, SAXException,
            ParserConfigurationException, XPathExpressionException
    {
        Loader loader = new Loader();
        Parser parser = new Parser();
        XPathProcessor xpp = new XPathProcessor();

        String html = loader.load(new URL(DATA_URL));
        Document document = parser.parse(html);
        NodeList nodes = xpp.evaluate(document,
                "//div[h1=\"Mimořádné události\"]/p[@class=\"stripe\"]/a[@class=\"more\"]");

        return process(nodes);
    }

    public Incident getIncident(String id) throws IOException, SAXException,
            ParserConfigurationException, XPathExpressionException
    {
        Loader loader = new Loader();
        Parser parser = new Parser();
        XPathProcessor xpp = new XPathProcessor();

        String html = loader.load(new URL(DATA_URL + id));
        Document document = parser.parse(html);
        NodeList stretch = xpp.evaluate(document, "//div[@class=\"left\"]/h1");
        NodeList origin = xpp.evaluate(document,
                "//div[@class=\"left\"]//p[contains(.,'Datum a čas vzniku')]/strong");
        NodeList assumption = xpp.evaluate(document,
                "//div[@class=\"left\"]//p[contains(.,'Předpokládané obnovení běžného provozu')]/strong");
        NodeList renew = xpp.evaluate(document,
                "//div[@class=\"left\"]//p[contains(.,'Čas obnovení provozu')]/strong");
        NodeList lines = xpp.evaluate(document,
                "//div[@class=\"left\"]//p[contains(.,'Dotčené linky')]/strong");
        NodeList events = xpp.evaluate(document,
                "//div[@class=\"left\"]//p[contains(.,'Typ události')]//strong");
        NodeList transportations = xpp.evaluate(document,
                "//div[@class=\"left\"]//p[contains(.,'Typ dotčených linek')]//strong");

        return process(id, stretch, origin, assumption, renew, lines, events,
                transportations);
    }
}
