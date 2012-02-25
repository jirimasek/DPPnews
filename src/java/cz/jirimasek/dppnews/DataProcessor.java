package cz.jirimasek.dppnews;

import cz.jirimasek.dppnews.dao.EventDAO;
import cz.jirimasek.dppnews.dao.IEventDAO;
import cz.jirimasek.dppnews.dao.IIncidentDAO;
import cz.jirimasek.dppnews.dao.ITransportationDAO;
import cz.jirimasek.dppnews.dao.IncidentDAO;
import cz.jirimasek.dppnews.dao.TransportationDAO;
import cz.jirimasek.dppnews.dao.entities.Incident;
import cz.jirimasek.dppnews.source.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class DataProcessor
{

    public void process() throws TwitterException
    {

        DataSource dataSource = new DataSource();
        IIncidentDAO idao = new IncidentDAO();
        IEventDAO edao = new EventDAO();
        ITransportationDAO tdao = new TransportationDAO();
        Twitter twitter = new TwitterFactory().getInstance();

        List<Incident> incidents = null;

        try
        {
            incidents = dataSource.getIncidents();
        }
        catch (Exception ex)
        {
            Logger.getLogger(DataProcessor.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        for (Incident incident : incidents)
        {
            try
            {
                Incident i = idao.get(incident.getKey());

                if (i == null || !i.isRenewed())
                {
                    Incident g = dataSource.getIncident(
                            incident.getKey().getName());

                    if (i == null || g.isRenewed())
                    {
                        Status status = twitter.updateStatus(g.toString());
                    }

                    idao.save(g);
                }
            }
            catch (Exception ex)
            {
                Logger.getLogger(DataProcessor.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        }
    }
}
