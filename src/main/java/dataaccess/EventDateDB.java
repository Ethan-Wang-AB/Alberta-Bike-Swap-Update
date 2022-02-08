/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Event;
import models.Event_Date;
import models.Event_Date_User;

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
     EntityTransaction trans=em.getTransaction();
        try {
                     
            Event event = a.getEvent();
            event.getEvent_date().add(a);
             trans.begin();
             em.persist(a);
             em.merge(event);
           
             trans.commit();
             return true;
          
        } catch(Exception ex){
        trans.rollback();
        return false;
        } finally {
            em.close();
        } 
    }

    @Override
    public boolean update(Event_Date a) {
              EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(a);

            trans.commit();
            return true;

        } catch (Exception ex) {
            trans.rollback();
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean delete(Event_Date a) {
     EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            Event event = a.getEvent();
            event.getEvent_date().remove(a);
           
            
            for(Event_Date_User u: a.getUsers()){
            
            em.remove(em.merge(u));
            }
            
               
            // a.getUsers().clear(); need to test if this way is cleaner and functional.
            trans.begin();
            em.remove(em.merge(a));
            em.merge(event);
            trans.commit();
            return true;
        } catch (Exception ex) {
            trans.rollback();
            return false;
        } finally {
            em.close();
        
        }   
    }

    @Override
    public ArrayList<Event_Date> getAll() {
       EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<Event_Date> lists;
            lists = em.createNamedQuery("Event_Date.findAll", Event_Date.class).getResultList();
            return (ArrayList<Event_Date>) lists;
        } finally {
            em.close();
        }
    }

    public final Event_Date getEvent_Date(int eventDateId) {
          EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            //System.out.println("Category get : "+name);

            Event_Date event_date = em.createNamedQuery("Event_Date.findById", Event_Date.class).setParameter("id", eventDateId).getSingleResult();
            return event_date;
        }catch(Exception ex){
        System.out.println("get event_date by id sql issue");
        ex.printStackTrace();
        return null;
        
        } finally {
            em.close();
        }

    }

    public static EventDateDB getInstance() {
        return eventdateDB;
    }

}
