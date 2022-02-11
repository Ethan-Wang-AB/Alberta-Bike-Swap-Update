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
import models.User;

/**
 *
 * @author 845593
 */
public class UserDB extends CommonDB<User> {

    private final static UserDB userDB = new UserDB();

    private UserDB() {
        super();
    }

    @Override
    public boolean add(User a) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {

            trans.begin();
            em.persist(a);

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
    public boolean update(User a) {
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
    public boolean delete(User a) {
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
    public ArrayList<User> getAll() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<User> lists;
            lists = em.createNamedQuery("User.findAll", User.class).getResultList();
            return (ArrayList<User>) lists;
        } catch (Exception ex) {
            System.out.println("get all users sql issue");
            ex.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    public final ArrayList<User> getAll(String role) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<User> lists;
            lists = em.createNamedQuery("User.findByRole", User.class).setParameter("roleName", role).getResultList();
            return (ArrayList<User>) lists;
        } catch (Exception ex) {
            System.out.println("get users by role sql issue");
            ex.printStackTrace();
            return null;
        } finally {
            em.close();
        }

    }

    public final User getUser(String username) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            //System.out.println("Category get : "+name);

            User user = em.createNamedQuery("User.findByUsername", User.class).setParameter("username", username).getSingleResult();
            return user;
        } catch (Exception ex) {
            System.out.println("get user by username sql issue");
            ex.printStackTrace();
            return null;

        } finally {
            em.close();
        }

    }

    public final User getUserByEmail(String email) {
          EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {

            User user = em.createNamedQuery("User.findByEmail", User.class).setParameter("email", email).getSingleResult();
            return user;
        } catch (Exception ex) {
            System.out.println("get user by email sql issue");
            ex.printStackTrace();
            return null;

        } finally {
            em.close();
        }

    }
public User getByUUID(String uuid){
         EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
   
            User user = em.createNamedQuery("User.findByResetPasswordUuid",User.class).setParameter("resetPasswordUuid",uuid).getSingleResult();
              //System.out.println("uuid in userDB after"+user.getResetPasswordUuid());
            return user;
        } finally {
            em.close();
        }
   
   }
    
    public static UserDB getInstance() {
        return userDB;

    }

}
