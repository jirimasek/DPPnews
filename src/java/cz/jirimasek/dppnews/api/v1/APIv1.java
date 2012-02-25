package cz.jirimasek.dppnews.api.v1;

import com.google.appengine.api.datastore.Key;
import cz.jirimasek.dppnews.api.v1.entities.RDF;
import cz.jirimasek.dppnews.api.v1.entities.RDFIncident;
import cz.jirimasek.dppnews.dao.EventDAO;
import cz.jirimasek.dppnews.dao.IEventDAO;
import cz.jirimasek.dppnews.dao.IIncidentDAO;
import cz.jirimasek.dppnews.dao.ITransportationDAO;
import cz.jirimasek.dppnews.dao.IncidentDAO;
import cz.jirimasek.dppnews.dao.TransportationDAO;
import cz.jirimasek.dppnews.dao.entities.Event;
import cz.jirimasek.dppnews.dao.entities.Incident;
import cz.jirimasek.dppnews.dao.entities.Transportation;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


@Path("/incidents")
public class APIv1
{
    @Context
    private UriInfo context;

    @GET
    @Produces(MediaType.TEXT_XML)
    public RDF retrieveIncidents(String content)
    {
        IIncidentDAO incidentDAO = new IncidentDAO();
        IEventDAO eventDAO = new EventDAO();
        ITransportationDAO transportationDAO = new TransportationDAO();
        
        RDF rdf = new RDF();

        List<Incident> incidents = incidentDAO.get();
        Map<Key, Event> events = eventDAO.get();
        Map<Key, Transportation> transportations = transportationDAO.get();
        
        for (Incident incident : incidents)
        {   
            rdf.addIncident(new RDFIncident(incident, events, transportations));
        }
        
        return rdf;
    }

    @GET
    @Produces(MediaType.TEXT_XML)
    @Path("{date}")
    public RDF retrieveIncidents(@PathParam("date") String date, String content)
    {
        IIncidentDAO incidentDAO = new IncidentDAO();
        IEventDAO eventDAO = new EventDAO();
        ITransportationDAO transportationDAO = new TransportationDAO();
        
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        Date d;
        
        try
        {
            d = formatter.parse(date);
        }
        catch (ParseException ex)
        {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        
        RDF rdf = new RDF();

        List<Incident> incidents = incidentDAO.get(d);
        Map<Key, Event> events = eventDAO.get();
        Map<Key, Transportation> transportations = transportationDAO.get();
        
        for (Incident incident : incidents)
        {   
            rdf.addIncident(new RDFIncident(incident, events, transportations));
        }
        
        return rdf;
    }
}
