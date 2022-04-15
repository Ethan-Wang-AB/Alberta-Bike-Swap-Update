/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 845593
 */
public abstract class CommonDB<T> {
    
    
    /**
     * 
     * @return true if addition is successful, false when it is unsuccessful
     */
    public abstract boolean add(T a);
   
    
     /**
     * 
     * @return true if update is successful, false when it is unsuccessful
     */
    public abstract boolean update(T a); 
    
    /**
     * 
     * @return true if deletion is successful, false when it is unsuccessful
     */
    public abstract boolean delete(T a);    
    
     /**
     * 
     * @return an ArrayList of the domain
     */
    public abstract List<T> getAll();
    

  
}
