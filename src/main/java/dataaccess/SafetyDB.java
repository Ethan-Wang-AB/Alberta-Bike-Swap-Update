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
import models.Safety;

/**
 *
 * @author 845593
 */
public class SafetyDB extends CommonDB<Safety> {

    private final static SafetyDB safetyDB = new SafetyDB();

    private SafetyDB() {
        super();
    }

    @Override
    public boolean add(Safety a) {
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
    public boolean update(Safety a) {
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
    public boolean delete(Safety a) {
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
    public ArrayList<Safety> getAll() {
           EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<Safety> lists;
            lists = em.createNamedQuery("Safety.findAll", Safety.class).getResultList();
            return (ArrayList<Safety>) lists;
        } finally {
            em.close();
        }
    }

    public static SafetyDB getInstance() {
        return safetyDB;
    }

}
