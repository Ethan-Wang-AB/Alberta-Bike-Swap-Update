/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Event;
import models.EventDate;
import models.EventDateUser;

/**
 *
 * @author 845593
 */
public class EventDateDB extends CommonDB<EventDate> {

    private final static EventDateDB eventdateDB = new EventDateDB();

    private EventDateDB() {
        super();
    }

    @Override
    public boolean add(EventDate a) {
      EntityManager em = DBUtil.getEmFactory().createEntityManager();
     EntityTransaction trans=em.getTransaction();
        try {
                     
            Event event = a.getEventId();
            event.getEventDateList().add(a);
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
    public boolean update(EventDate a) {
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
    public boolean delete(EventDate a) {
     EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            Event event = a.getEventId();
            event.getEventDateList().remove(a);
           
            
            for(EventDateUser u: a.getEventDateUserList()){
            
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
    public List<EventDate> getAll() {
       EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<EventDate> lists;
            lists = em.createNamedQuery("EventDate.findAll", EventDate.class).getResultList();
            return  lists;
        } finally {
            em.close();
        }
    }
    
       public List<EventDate> getAllByEvent(Event e) {
       EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<EventDate> lists;
            lists = em.createNamedQuery("EventDate.findAllByEvent", EventDate.class).setParameter("eventId", e.getEventId()).getResultList();
                
            
            
            return lists;
        } finally {
            em.close();
        }
    }

    public final EventDate getEvent_Date(int eventDateId) {
          EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            //System.out.println("Category get : "+name);

            EventDate event_date = em.createNamedQuery("EventDate.findByEventDateId", EventDate.class).setParameter("eventDateid", eventDateId).getSingleResult();
            return event_date;
        }catch(Exception ex){
        System.out.println("get event_date by id sql issue");
        ex.printStackTrace();
        return null;
        
        } finally {
            em.close();
        }

    }
    
      public final EventDate getEvent_Date(Date date) {
          EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            //System.out.println("Category get : "+name);

            EventDate event_date = em.createNamedQuery("EventDate.findByStartDate", EventDate.class).setParameter("startDate", date).getSingleResult();
            return event_date;
        }catch(Exception ex){
        System.out.println("get event_date by date sql issue");
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
