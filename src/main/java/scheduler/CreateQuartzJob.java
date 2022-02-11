/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduler;

/**
 *
 * @author 845593
 */

import dataaccess.EventDateDB;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.mail.MessagingException;
import javax.naming.NamingException;
import models.EventDate;
import models.EventDateUser;
import models.User;
import org.apache.log4j.Logger;
import org.quartz.Calendar;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import services.GmailService;

public class CreateQuartzJob implements Job{
    private  EventDateDB eventDateDB=EventDateDB.getInstance();
    private Logger log = Logger.getLogger(CreateQuartzJob.class);

    public void execute(JobExecutionContext jExeCtx) throws JobExecutionException {


       //handle JobExecutionException  

        //debug message 
        Calendar calendar=jExeCtx.getCalendar();
        EventDate eventDate=new EventDate();
        
        List<EventDateUser> users=eventDate.getEventDateUserList();
        
        for(EventDateUser e: users){
        
             String email=e.getUserId().getEmail();
             String body=String.format("%s%s%n%s%n%n%s%n%s", "Hi ",e.getUserId().getName()+" ,","Please remember to attend the coming Alberta Bike Swap event, thank you.","Regards,","Laura");
            try {
                GmailService.sendMail(email, "Remind to attend tomorrow's Alberta Bike Swap Event", body, false);
            } catch (MessagingException ex) {
                java.util.logging.Logger.getLogger(CreateQuartzJob.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NamingException ex) {
                java.util.logging.Logger.getLogger(CreateQuartzJob.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
