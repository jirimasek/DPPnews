package cz.jirimasek.dppnews.dao;


import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.google.appengine.api.datastore.Key;

import cz.jirimasek.dppnews.dao.entities.Event;
import java.util.HashMap;
import java.util.Map;

public class EventDAO implements IEventDAO
{

    PersistenceManager persistenceManager;

    /**
     * Vytvoří novou instanci třídy <code>EventDAO</code>.
     */
    public EventDAO()
    {
        persistenceManager = PMF.get().getPersistenceManager();
    }

    /**
     * Vrátí typ mimořádné události podle zadaného identifikátoru.
     * 
     * @param key identifikátor
     * @return typ mimořádné události
     */
    public Event get(Key key)
    {
        try
        {
            return persistenceManager.getObjectById(Event.class, key);
        }
        catch (Exception e)
        {
            return null;
        }
    };

    /**
     * Vrátí <code>Map</code> se všemi typy mimořádných událostí.
     * 
     * @return <code>Map</code> se všemi typy mimořádných událostí
     */
    public Map<Key, Event> get()
    {
        String sql = "select from " + Event.class.getName();
        Query query = persistenceManager.newQuery(sql);
        @SuppressWarnings("unchecked")
        List<Event> events = (List<Event>) query.execute();

        Map<Key, Event> output = new HashMap<Key, Event>();
        
        for (Event event : events)
        {
            output.put(event.getKey(), event);
        }
        
        return output;
    };

    /**
     * Uloží informace o typu mimořádé události.
     * 
     * @param event typ mimořádné události
     */
    public void save(Event event)
    {
        try
        {
            persistenceManager.makePersistent(event);
        }
        finally
        {
            persistenceManager.flush();
        }
    };
}