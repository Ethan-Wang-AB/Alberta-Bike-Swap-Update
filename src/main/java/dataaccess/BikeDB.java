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
import models.User;

/**
 *
 * @author 845593
 */
public class BikeDB extends CommonDB<Bike> {

    private final static BikeDB bikeDB = new BikeDB();

    private BikeDB() {
        super();
    }

    public ArrayList<Bike> getAll() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<Bike> lists;
            lists = em.createNamedQuery("Bike.findAll", Bike.class).getResultList();
            return (ArrayList<Bike>) lists;
        } finally {
            em.close();
        }

    }

    public final ArrayList<Bike> getAll(String cat) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<Bike> lists;
            lists = em.createNamedQuery("Bike.findByCategory", Bike.class).getResultList();
            return (ArrayList<Bike>) lists;
        } finally {
            em.close();
        }

    }

    public final Bike getBike(int id) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            //System.out.println("Category get : "+name);

            Bike bike = em.createNamedQuery("Bike.findById", Bike.class).setParameter("id", id).getSingleResult();
            return bike;
        }catch(Exception ex){
        System.out.println("get bike by id sql issue");
        ex.printStackTrace();
        return null;
        
        } finally {
            em.close();
        }

    }

    @Override
    public boolean add(Bike a) {
  EntityManager em = DBUtil.getEmFactory().createEntityManager();
             EntityTransaction trans=em.getTransaction();
        try {
                     
            User user = a.getUserId();
            user.getBikeList().add(a);
             trans.begin();
             em.persist(a);
             em.merge(user);
           
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
    public boolean update(Bike a) {
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
    public boolean delete(Bike a) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            User user = a.getUserId();
            user.getBikeList().remove(a);
            trans.begin();
            em.remove(em.merge(a));
            em.merge(user);
            trans.commit();
            return true;
        } catch (Exception ex) {
            trans.rollback();
            return false;
        } finally {
            em.close();
        
        }   
    }

    public static BikeDB getInstance() {
        return bikeDB;

    }

}
