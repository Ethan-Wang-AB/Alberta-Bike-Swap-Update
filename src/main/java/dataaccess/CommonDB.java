/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.ArrayList;

/**
 *
 * @author 845593
 */
public abstract class CommonDB<T> {
    
    
    /**
     * 
     * @param certain type of the domain
     * @return true if addition is successful, false when it is unsuccessful
     */
    public abstract boolean add(T a);
   
    
     /**
     * 
     * @param certain type of the domain
     * @return true if update is successful, false when it is unsuccessful
     */
    public abstract boolean update(T a); 
    
    /**
     * 
     * @param certain type of the domain
     * @return true if deletion is successful, false when it is unsuccessful
     */
    public abstract boolean delete(T a);    
    
     /**
     * 
     * @param certain type of the domain
     * @return an arraylist of the domain
     */
    public abstract ArrayList<T> getAll();
    

  
    
}
