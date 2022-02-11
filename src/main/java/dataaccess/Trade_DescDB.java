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
import models.TradeDesc;
import models.User;

/**
 *
 * @author 845593
 */
public class Trade_DescDB extends CommonDB<TradeDesc> {

    private final static Trade_DescDB tradeDescDB = new Trade_DescDB();

    private Trade_DescDB() {
        super();
    }

    @Override
    public boolean add(TradeDesc a) {
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
        }        }

    @Override
    public boolean update(TradeDesc a) {
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
        }    }

    @Override
    public boolean delete(TradeDesc a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TradeDesc> getAll() {
 EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<TradeDesc> lists;
            lists = em.createNamedQuery("TradeDesc.findAll", TradeDesc.class).getResultList();
            return (ArrayList<TradeDesc>) lists;
        } finally {
            em.close();
        }
    }
    public TradeDesc getTradeDesc(int id){
    EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            //System.out.println("Category get : "+name);

            TradeDesc desc = em.createNamedQuery("TradeDesc.findByDescId", TradeDesc.class).setParameter("descId", id).getSingleResult();
            return desc;
        }catch(Exception ex){
        System.out.println("get Desc by id sql issue");
        ex.printStackTrace();
        return null;
        
        } finally {
            em.close();
        }
    }
    
    public static Trade_DescDB getInstance(){
    return tradeDescDB;
    }

}
