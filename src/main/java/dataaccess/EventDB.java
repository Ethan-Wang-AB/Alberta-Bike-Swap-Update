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
import models.User;

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
         EntityTransaction trans=em.getTransaction();
        try {
                      
      
             trans.begin();
             em.persist(a);
                       
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
    public boolean update(Event a) {
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
    public boolean delete(Event a) {
                           EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
     
            trans.begin();
            em.remove(em.merge(a));
        
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
    public List<Event> getAll() {
            EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<Event> lists;
            lists = em.createNamedQuery("Event.findAll", Event.class).getResultList();
            return lists;
        } finally {
            em.close();
        }

    }

    public final Event getEvent(int eventId) {
           EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            //System.out.println("Category get : "+name);

            Event bike = em.createNamedQuery("Event.findByEventId", Event.class).setParameter("eventId", eventId).getSingleResult();
            return bike;
        } catch(Exception ex){
        System.out.println("get event by id sql issue");
        ex.printStackTrace();
        return null;
        
        }finally {
            em.close();
        }

    }

    public static EventDB getInstance() {
        return eventDB;
    }

}
