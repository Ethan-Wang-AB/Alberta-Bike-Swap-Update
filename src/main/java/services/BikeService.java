/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.BikeDB;
import models.Bike;

/**
 *
 * @author 845593
 */
public class BikeService {
    BikeDB bikeDB=BikeDB.getInstance();
    
     public final Bike getBike(int id)
    {
	Bike bike=bikeDB.getBike(id);
        return bike;
        
    }    
    
    
    public final void updateBike(Bike bike)
    {
        bikeDB.update(bike);
        
    }    
    
    
    public final void deleteBike(Bike bike)
    {
        bikeDB.delete(bike);
    }    
}
