package cz.jirimasek.dppnews.dao;


import com.google.appengine.api.datastore.Key;

import cz.jirimasek.dppnews.dao.entities.Incident;
import java.util.Date;


import java.util.List;

/**
 * Rozhraní <code>IIncidentDAO</code> umožňuje získávat data o mimořádných
 * událostech.
 * 
 * @author masekj@gmail.com
 */
public interface IIncidentDAO
{

    /**
     * Vrátí informace o mimořádné události podle zadaného identifikátoru.
     * 
     * @param key identifikátor
     * @return mimořádná událost
     */
    public Incident get(Key key);

    /**
     * Vrátí <code>List</code> se všemi mimořádnými událostmi.
     * 
     * @return <code>List</code> se všemi mimořádnými událostmi
     */
    public List<Incident> get();

    /**
     * Vrátí <code>List</code> se všemi mimořádnými událostmi, které se odehrály
     * v daný den.
     * 
     * @return <code>List</code> se mimořádnými událostmi
     */
    public List<Incident> get(Date date);

    /**
     * Uloží informace o mimořádné události.
     * 
     * @param incident mimořádná událost
     */
    public void save(Incident incident);

}
