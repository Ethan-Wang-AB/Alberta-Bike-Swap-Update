/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import models.Event_Date;

/**
 *
 * @author 845593
 */
public class EventDateDB extends CommonDB<Event_Date> {

    private final static EventDateDB eventdateDB = new EventDateDB();

    private EventDateDB() {
        super();
    }

    @Override
    public boolean add(Event_Date a) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Event_Date a) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Event_Date a) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Event_Date> getAll() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public final Event_Date getEvent(int eventDateId) {
        return null;

    }

    public static EventDateDB getInstance() {
        return eventdateDB;
    }

}
