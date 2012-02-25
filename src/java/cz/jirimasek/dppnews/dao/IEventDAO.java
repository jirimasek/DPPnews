package cz.jirimasek.dppnews.dao;


import com.google.appengine.api.datastore.Key;

import cz.jirimasek.dppnews.dao.entities.Event;

import java.util.Map;

/**
 * Rozhraní <code>IEventDAO</code> umožňuje získávat data o typech mimořádných
 * událostí.
 * 
 * @author masekj@gmail.com
 */
public interface IEventDAO
{

    /**
     * Vrátí typ mimořádné události podle zadaného identifikátoru.
     * 
     * @param key identifikátor
     * @return typ mimořádné události
     */
    public Event get(Key key);

    /**
     * Vrátí <code>Map</code> se všemi typy mimořádných událostí.
     * 
     * @return <code>Map</code> se všemi typy mimořádných událostí
     */
    public Map<Key, Event> get();

    /**
     * Uloží informace o typu mimořádé události.
     * 
     * @param event typ mimořádné události
     */
    public void save(Event event);

}
