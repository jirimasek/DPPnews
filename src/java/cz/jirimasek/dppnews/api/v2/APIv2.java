package cz.jirimasek.dppnews.api.v2;

import com.google.appengine.api.datastore.Key;
import cz.jirimasek.dppnews.api.v2.entities.JSONFactory;
import cz.jirimasek.dppnews.api.v2.entities.JSONIncident;
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
import java.util.ArrayList;
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

/**
 * Třída <code>APIv2</code>
 * 
 * @author Jiří Mašek <email@jirimasek.cz>
 */
@Path("v2/incidents")
public class APIv2 
{
    @Context
    private UriInfo context;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<JSONIncident> retrieveIncidents(String content)
    {
        IIncidentDAO incidentDAO = new IncidentDAO();
        IEventDAO eventDAO = new EventDAO();
        ITransportationDAO transportationDAO = new TransportationDAO();
        
        List<Incident> incidents = incidentDAO.get();
        Map<Key, Event> events = eventDAO.get();
        Map<Key, Transportation> transportations = transportationDAO.get();
        
        JSONFactory jsonFactory = new JSONFactory();
        
        List<JSONIncident> output = new ArrayList<JSONIncident>();
        
        for (Incident incident : incidents)
        {   
            output.add(jsonFactory.createIncident(incident, events, transportations));
        }
        
        return output;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{date}")
    public List<JSONIncident> retrieveIncidents(@PathParam("date") String date, String content)
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

        List<Incident> incidents = incidentDAO.get(d);
        Map<Key, Event> events = eventDAO.get();
        Map<Key, Transportation> transportations = transportationDAO.get();
        
        JSONFactory jsonFactory = new JSONFactory();
        
        List<JSONIncident> output = new ArrayList<JSONIncident>();
        
        for (Incident incident : incidents)
        {   
            output.add(jsonFactory.createIncident(incident, events, transportations));
        }
        
        return output;
    }
}
