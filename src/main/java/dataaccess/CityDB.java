/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.City;
import models.Event;

/**
 *
 * @author 845593
 */
public class CityDB extends CommonDB<City>{

    @Override
    public boolean add(City a) {
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
    public boolean update(City a) {
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
    public boolean delete(City a) {
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
        
        }     }

    @Override
    public List getAll() {
          EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<City> lists;
            lists = em.createNamedQuery("City.findAll", City.class).getResultList();
            return lists;
        } finally {
            em.close();
        }    }
    
    public City getCity(int id){
      EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            //System.out.println("Category get : "+name);

            City city = em.createNamedQuery("City.findByCityId", City.class).setParameter("cityId", id).getSingleResult();
            return city;
        } catch(Exception ex){
        System.out.println("get city by id sql issue");
        ex.printStackTrace();
        return null;
        
        }finally {
            em.close();
        }
    
    }
    
}
