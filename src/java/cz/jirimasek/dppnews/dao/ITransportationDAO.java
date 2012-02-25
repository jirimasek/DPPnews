package cz.jirimasek.dppnews.dao;


import com.google.appengine.api.datastore.Key;

import cz.jirimasek.dppnews.dao.entities.Transportation;

import java.util.Map;

/**
 * Rozhraní <code>ITransportationDAO</code> umožňuje získávat data o typech
 * dotčených linek.
 * 
 * @author masekj@gmail.com
 */
public interface ITransportationDAO
{

    /**
     * Vrátí typ dotčených linek podle zadaného identifikátoru.
     * 
     * @param key identifikátor
     * @return typ dotčených linek
     */
    public Transportation get(Key key);

    /**
     * Vrátí <code>Map</code> se všemi typy dotčených linek.
     * 
     * @return <code>Map</code> se všemi typy dotčených linek
     */
    public Map<Key, Transportation> get();

    /**
     * Uloží typ dotčených linek.
     * 
     * @param transportation typ dotčených linek
     */
    public void save(Transportation transportation);

}
