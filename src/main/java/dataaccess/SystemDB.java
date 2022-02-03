/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.io.File;

/**
 *
 * @author 845593
 */
public class SystemDB {
    private final static SystemDB systemDB=new SystemDB();
   private SystemDB(){
    super();
    }
    public final boolean toggleOpenStatus()
    {
		return false;
        
    }    
    
    
    public final boolean backup(File file)
    {
		return false;
        
    }    
    
    
    public final boolean restore(File file)
    {
		return false;
        
    }    
    
    
    public final boolean archiveData()
    {
		return false;
        
    }    
    
    
    public static SystemDB getInstance()
    {
		return systemDB;
        
    }    
    
    
 
}
