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
import models.TradeDesc;

import models.TradeOthers;

/**
 *
 * @author 845593
 */
public class Trade_OthersDB extends CommonDB<TradeOthers> {
   private final static Trade_OthersDB tradeOthersDB = new Trade_OthersDB();

    private Trade_OthersDB() {
        super();
    }

    public ArrayList<TradeOthers> getAll() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<TradeOthers> lists;
            lists = em.createNamedQuery("TradeOthers.findAll", TradeOthers.class).getResultList();
            return (ArrayList<TradeOthers>) lists;
        } finally {
            em.close();
        }

    }

    public final ArrayList<TradeOthers> getAll(TradeDesc cat) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<TradeOthers> lists;
            lists = em.createNamedQuery("TradeOthers.findAllByDesc", TradeOthers.class).setParameter("descId", cat.getDescId()).getResultList();
            return (ArrayList<TradeOthers>) lists;
        } finally {
            em.close();
        }

    }

    public final TradeOthers getTradeOthers(int id) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            //System.out.println("Category get : "+name);

            TradeOthers tradeOthers = em.createNamedQuery("TradeOthers.findByTradeOthersId", TradeOthers.class).setParameter("tradeOthersId", id).getSingleResult();
            return tradeOthers;
        }catch(Exception ex){
        System.out.println("get tradeOthers by id sql issue");
        ex.printStackTrace();
        return null;
        
        } finally {
            em.close();
        }

    }

    @Override
    public boolean add(TradeOthers a) {
  EntityManager em = DBUtil.getEmFactory().createEntityManager();
             EntityTransaction trans=em.getTransaction();
        try {
                     
            TradeDesc desc = a.getDescId();
            desc.getTradeOthersList().add(a);
             trans.begin();
             em.persist(a);
             em.merge(desc);
           
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
    public boolean update(TradeOthers a) {
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
    public boolean delete(TradeOthers a) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            TradeDesc desc = a.getDescId();
           desc.getTradeOthersList().remove(a);
            trans.begin();
            em.remove(em.merge(a));
            em.merge(desc);
            trans.commit();
            return true;
        } catch (Exception ex) {
            trans.rollback();
            return false;
        } finally {
            em.close();
        
        }   
    }
 public static Trade_OthersDB getInstance(){
         return tradeOthersDB;
 }
}
