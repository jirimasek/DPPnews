package cz.jirimasek.dppnews.dao;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.google.appengine.api.datastore.Key;

import cz.jirimasek.dppnews.dao.entities.Incident;

public class IncidentDAO implements IIncidentDAO
{

    PersistenceManager persistenceManager;

    /**
     * Vytvoří novou instanci třídy <code>IncidentDAO</code>.
     */
    public IncidentDAO()
    {
        persistenceManager = PMF.get().getPersistenceManager();
    }

    /**
     * Vrátí informace o mimořádné události podle zadaného identifikátoru.
     * 
     * @param key identifikátor
     * @return mimořádná událost
     */
    public Incident get(Key key)
    {
        try
        {
            return persistenceManager.getObjectById(Incident.class, key);
        }
        catch (Exception e)
        {
            return null;
        }
    }

    ;

    /**
     * Vrátí <code>List</code> se všemi mimořádnými událostmi.
     * 
     * @return <code>List</code> se všemi mimořádnými událostmi
     */
    public List<Incident> get()
    {
        Date date = new Date();
        Date oF = new Date(date.getTime() - 86400000);
        
        Query query = persistenceManager.newQuery(Incident.class,
                              "origin > oF");
        query.declareParameters("java.util.Date oF");

        return (List<Incident>) query.execute(oF);
    }
    
    /**
     * Vrátí <code>List</code> se všemi mimořádnými událostmi, které se odehrály
     * v daný den.
     * 
     * @return <code>List</code> se mimořádnými událostmi
     */
    public List<Incident> get(Date date)
    {
        Date oF = new Date(date.getTime() - 1);
        Date oT = new Date(date.getTime() + 86400000);
        
        Query query = persistenceManager.newQuery(Incident.class,
                              "origin > oF && origin < oT");
        query.declareParameters("java.util.Date oF, java.util.Date oT");

        return (List<Incident>) query.execute(oF, oT);
    }

    /**
     * Uloží informace o mimořádné události.
     * 
     * @param incident mimořádná událost
     */
    public void save(Incident incident)
    {
        try
        {
            persistenceManager.makePersistent(incident);
        }
        finally
        {
            persistenceManager.flush();
        }
    }
}
