/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import models.Diet;
import models.Event;

/**
 *
 * @author 845593
 */
public class DietDB extends CommonDB<Diet>{

    @Override
    public boolean add(Diet a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Diet a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Diet a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Diet> getAll() {
 EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<Diet> lists;
            lists = em.createNamedQuery("Diet.findAll", Diet.class).getResultList();
            return lists;
        } finally {
            em.close();
        }
    }
    
        public final Diet getDiet(int dietId) {
           EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            //System.out.println("Category get : "+name);

            Diet diet = em.createNamedQuery("Diet.findByDietId", Diet.class).setParameter("dietId", dietId).getSingleResult();
            return diet;
        } catch(Exception ex){
        System.out.println("get diet by id sql issue");
        ex.printStackTrace();
        return null;
        
        }finally {
            em.close();
        }

    }
    
}
