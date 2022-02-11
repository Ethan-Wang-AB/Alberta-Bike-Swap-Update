/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.SystemDB;
import java.io.File;
import models.EventDate;

/**
 *
 * @author 845593
 */
public class SystemService {
    private SystemDB systemDB=SystemDB.getInstance();
//     public final boolean toggleOpenStatus()
//    {
//		return false;
//        
//    }    
    
    
    public final boolean backup(File file)
    {
		return systemDB.backup(file);
        
    }    
    
    
    public final boolean restore(File file)
    {
		return systemDB.restore(file);
        
    }    
    
    
    public final boolean archiveData()
    {
		return systemDB.archiveData();
        
    }    
    
    
    private final void notify(EventDate event)
    {
        systemDB.notifyAll();
    }    
}
