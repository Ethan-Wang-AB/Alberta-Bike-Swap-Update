/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import models.User;

/**
 *
 * @author 845593
 */
public class UserDB extends CommonDB<User>{
    private final static UserDB userDB=new UserDB();

    
    private UserDB(){
    super();
    }
    @Override
    public boolean add(User a) {
                        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(User a) {
                        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(User a) {
                        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<User> getAll() {
                        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public final ArrayList<User> getAll(String role)
    {
		return null;
        
    }    
    
    
    public final User getUser(String username)
    {
		return null;
        
    }    
    
    
    public final User getUserByEmail(String email)
    {
		return null;
        
    }  
    
      public static UserDB getInstance()
    {
		return userDB;
        
    } 
    
}
