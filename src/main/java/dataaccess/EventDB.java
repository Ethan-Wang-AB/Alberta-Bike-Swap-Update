/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import models.Event;

/**
 *
 * @author 845593
 */
public class EventDB extends CommonDB<Event> {

    private final static EventDB eventDB = new EventDB();

    private EventDB() {
        super();
    }

    @Override
    public boolean add(Event a) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Event a) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Event a) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Event> getAll() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public final Event getEvent(int eventId) {
        return null;

    }

    public static EventDB getInstance() {
        return eventDB;
    }

}
