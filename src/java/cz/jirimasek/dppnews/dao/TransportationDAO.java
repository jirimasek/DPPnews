package cz.jirimasek.dppnews.dao;


import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.google.appengine.api.datastore.Key;

import cz.jirimasek.dppnews.dao.entities.Transportation;
import java.util.HashMap;
import java.util.Map;

public class TransportationDAO implements ITransportationDAO
{

    PersistenceManager persistenceManager;

    /**
     * Vytvoří novou instanci třídy <code>TransportationDAO</code>.
     */
    public TransportationDAO()
    {
        persistenceManager = PMF.get().getPersistenceManager();
    }

    /**
     * Vrátí typ dotčených linek podle zadaného identifikátoru.
     * 
     * @param key identifikátor
     * @return typ dotčených linek
     */
    public Transportation get(Key key)
    {
        try
        {
            return persistenceManager.getObjectById(Transportation.class, key);
        }
        catch (Exception e)
        {
            return null;
        }
    };

    /**
     * Vrátí <code>Map</code> se všemi typy dotčených linek.
     * 
     * @return <code>Map</code> se všemi typy dotčených linek
     */
    public Map<Key, Transportation> get()
    {
        String sql = "select from " + Transportation.class.getName();
        Query query = persistenceManager.newQuery(sql);
        @SuppressWarnings("unchecked")
        List<Transportation> transportations = (List<Transportation>) query.execute();

        Map<Key, Transportation> output = new HashMap<Key, Transportation>();
        
        for (Transportation transportation : transportations)
        {
            output.put(transportation.getKey(), transportation);
        }
        
        return output;
    };

    /**
     * Uloží typ dotčených linek.
     * 
     * @param transportation typ dotčených linek
     */
    public void save(Transportation transportation)
    {
        try
        {
            persistenceManager.makePersistent(transportation);
        }
        finally
        {
            persistenceManager.flush();
        }
    };

}
