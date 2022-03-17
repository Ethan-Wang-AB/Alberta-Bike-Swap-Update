/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.SystemDB;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import models.EventDate;
import scheduler.QuartzScheduler;

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
    
    
    public final boolean backup() throws IOException
    {
		return systemDB.backup();
        
    }    
    
    
    public final boolean restore(File file)
    {
		return systemDB.restore(file);
        
    }    
    
    
    public final boolean archiveData()
    {
		return systemDB.archiveData();
        
    }    
    
    
    private final void notify(EventDate event,ServletContext context)
    {
        Date date=event.getStartDate();
        QuartzScheduler scheduler=new QuartzScheduler(); 
        scheduler.setStartTime(event);
        ServletContextEvent ctx=new ServletContextEvent(context);
        scheduler.contextInitialized(ctx);
    }    
}
