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

import models.Trade;
import models.User;

/**
 *
 * @author 845593
 */
public class TradeDB extends CommonDB<Trade> {

    private final static TradeDB tradeDB = new TradeDB();

    private TradeDB() {
        super();
    }

    @Override
    public boolean add(Trade a) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            User seller = a.getSellerId();
            User buyer = a.getBuyerId();
            seller.getBikeList().remove(a.getBikeId());
            buyer.getBikeList().add(a.getBikeId());
            Bike bike = a.getBikeId();
            bike.setUserId(buyer);
            trans.begin();

            em.persist(a);

            em.merge(buyer);
            em.merge(seller);
            em.merge(bike);

            trans.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            trans.rollback();
            return false;

        } finally {
            em.close();
        }
    }

    @Override
    public boolean update(Trade a) {
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
    /**
     * Only delete trade record when archive data, otherwise trades records will retain all the time
     * @param a the trade record to be deleted
     * @return true deletion successful, otherwise false
     */
    @Override
    public boolean delete(Trade a) {
     EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            //User seller = a.getSeller();
            User buyer=a.getBuyerId();
           // seller.getBikes().add(a.getBike());
            buyer.getBikeList().remove(a.getBikeId()); // for archive data, remove record
            
            trans.begin();
            em.remove(em.merge(a));
            em.merge(buyer);
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
    public ArrayList<Trade> getAll() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<Trade> lists;
            lists = em.createNamedQuery("Trade.findAll", Trade.class).getResultList();
            return (ArrayList<Trade>) lists;
        } finally {
            em.close();
        }
    }

    public final ArrayList<Trade> getAll(String cat) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<Trade> lists;
            lists = em.createNamedQuery("Trade.findByCategory", Trade.class).setParameter("category", cat).getResultList();
            return (ArrayList<Trade>) lists;
        } finally {
            em.close();
        }

    }

    public final Trade getTrade(int id) {
       EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {

            Trade trade = em.createNamedQuery("Trade.findById", Trade.class).setParameter("id", id).getSingleResult();
            return trade;
        }catch(Exception ex){
        System.out.println("get trade by id sql issue");
        ex.printStackTrace();
        return null;
        
        } finally {
            em.close();
        }

    }

    public static TradeDB getInstance() {
        return tradeDB;

    }
}
