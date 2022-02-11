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
import models.Role;

/**
 *
 * @author 845593
 */
public class RoleDB extends CommonDB<Role> {

    private final static RoleDB roleDB = new RoleDB();

    private RoleDB() {
        super();
    }

    @Override
    public boolean add(Role a) {
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
    public boolean update(Role a) {
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
    public boolean delete(Role a) {
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
    public ArrayList<Role> getAll() {
            EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<Role> lists;
            lists = em.createNamedQuery("Role.findAll", Role.class).getResultList();
            return (ArrayList<Role>) lists;
        } finally {
            em.close();
        }
    }

    public final Role getByName(String name) {
                EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {

            Role role = em.createNamedQuery("Role.findByRoleName", Role.class).setParameter("roleName", name).getSingleResult();
            return role;
        } catch(Exception ex){
        System.out.println("get role by name sql issue");
        ex.printStackTrace();
        return null;
        
        }finally {
            em.close();
            
        }

    }

    public final Role getRole(int id) {
            EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {

            Role role = em.createNamedQuery("Role.findByRoleId", Role.class).setParameter("roleId", id).getSingleResult();
            return role;
        } catch(Exception ex){
        System.out.println("get role by id sql issue");
        ex.printStackTrace();
        return null;
        
        }finally {
            em.close();
        }

    }

    public static RoleDB getInstance() {
        return roleDB;
    }

}
