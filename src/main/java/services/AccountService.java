/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.UserDB;
import models.User;

/**
 *
 * @author 845593
 */
public class AccountService {
      
    private UserDB userDB=UserDB.getInstance();
    public final User login(String username, String password)
    {
		return null;
        
    }    
    
    
    public final void logout(User user)
    {
        
    }    
    
    
    public final void resetpassword(String password, String uuid)
    {
        
    }    
    
    
    public final void update(User user)
    {
        
    }    
    
    
    public final void deactive(User user)
    {
        
    }    
}
