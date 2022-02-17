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
import models.Announcement;
import models.Bike;

/**
 *
 * @author 845593
 */
public class AnnouncementDB extends CommonDB<Announcement> {
    private static AnnouncementDB announcementDB=new AnnouncementDB();
    
    private AnnouncementDB(){}
    @Override
    public boolean add(Announcement a) {
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

    
    public Announcement getAnnouncement(int id){
    
           EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            //System.out.println("Category get : "+name);

            Announcement ann = em.createNamedQuery("Announcement.findByAnnouncementId", Announcement.class).setParameter("announcementId", id).getSingleResult();
            return ann;
        }catch(Exception ex){
        System.out.println("get announcement by id sql issue");
        ex.printStackTrace();
        return null;
        
        } finally {
            em.close();
        }
    }
    
    @Override
    public boolean update(Announcement a) {
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
    public boolean delete(Announcement a) {
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
        
        }       }

    @Override
    public ArrayList getAll() {
      EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<Announcement> lists;
            lists = em.createNamedQuery("Announcement.findAll", Announcement.class).getResultList();
            return (ArrayList<Announcement>) lists;
        } finally {
            em.close();
        }    }
    
    
    public static AnnouncementDB getInstance(){
    return announcementDB;
    }
    
}
