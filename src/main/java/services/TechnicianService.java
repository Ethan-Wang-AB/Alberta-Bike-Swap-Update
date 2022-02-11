/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.BikeDB;
import dataaccess.UserDB;
import models.Bike;
import models.User;

/**
 *
 * @author 845593
 */
public class TechnicianService {
    	private BikeDB bikeDB=BikeDB.getInstance();      
    private UserDB userDB=UserDB.getInstance();      

    
    
    
    public final boolean checkIndex(long index)
    {
		return false;
        
    }    
    
    
    public final boolean setStatusToSell(Bike bike)
    {
      bike.setToSell(true);
      bike.setDonate(false);
      return   bikeDB.update(bike);
    }    
    
    public final boolean setStatusToDonate(Bike bike){
      bike.setToSell(false);
      bike.setDonate(true);
      return   bikeDB.update(bike);
    }
    
    public final boolean setStatusToRepair(Bike bike){
     bike.setToSell(false);
      bike.setDonate(false);
       return   bikeDB.update(bike);
    }
    
    public final void invalidTicket(User user)
    {
        user.setTicket(-99);//set invalid ticket to be -99
        userDB.update(user);
        
    }    
}
