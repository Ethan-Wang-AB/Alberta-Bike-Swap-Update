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
import models.Bike;
import models.EventDate;
import models.EventDateUser;
import models.User;

/**
 *
 * @author 845593
 */
public class EventDateUserDB extends CommonDB<EventDateUser> {

    private final static EventDateUserDB eventDateUserDB = new EventDateUserDB();

    private EventDateUserDB() {
        super();
    }

    @Override
    public boolean add(EventDateUser a) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {

            EventDate eventDate = a.getEventDateId();
            eventDate.getEventDateUserList().add(a);
            User user = a.getUserId();
            user.getEventDateUserList().add(a);
            trans.begin();
            em.persist(a);
            em.merge(user);
            em.merge(eventDate);

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
    public boolean update(EventDateUser a) {
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
    public boolean delete(EventDateUser a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EventDateUser> getAll() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<EventDateUser> lists;
            lists = em.createNamedQuery("EventDateUser.findAll", EventDateUser.class).getResultList();
            return lists;
        } finally {
            em.close();
        }
    }

    public static EventDateUserDB getInstance() {

        return eventDateUserDB;
    }
}
