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
import models.Faq;

/**
 *
 * @author 845593
 */
public class FaqDB extends CommonDB<Faq> {

    private final static FaqDB faqDB = new FaqDB();

    private FaqDB() {
        super();
    }

    @Override
    public boolean add(Faq a) {
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
    public boolean update(Faq a) {
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
    public boolean delete(Faq a) {
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
    public ArrayList<Faq> getAll() {
      EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<Faq> lists;
            lists = em.createNamedQuery("Faq.findAll", Faq.class).getResultList();
            return (ArrayList<Faq>) lists;
        } finally {
            em.close();
        }
    }

    public static FaqDB getInstance() {
        return faqDB;
    }

}
