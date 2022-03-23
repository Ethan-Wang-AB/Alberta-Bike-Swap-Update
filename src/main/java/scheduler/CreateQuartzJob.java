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
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import javax.mail.MessagingException;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import models.EventDate;
import models.EventDateUser;
import models.User;
import org.apache.log4j.Logger;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import services.GmailService;

public class CreateQuartzJob implements Job {

    private EventDateDB eventDateDB = EventDateDB.getInstance();
    private Logger log = Logger.getLogger(CreateQuartzJob.class);

    public void execute(JobExecutionContext jExeCtx) throws JobExecutionException {

        //handle JobExecutionException  
        //debug message 
        ServletContext servletContext = (ServletContext) jExeCtx.getMergedJobDataMap().get("servletContext");
      //  ArrayList<EventDate> events = (ArrayList<EventDate>) servletContext.getAttribute("events");
        EventDate e=(EventDate) (jExeCtx.getJobDetail().getJobDataMap().get("event"));
//        for (EventDate event : events) {

//            Calendar test = Calendar.getInstance();
//            Calendar schedule = Calendar.getInstance();
//            schedule.setTime(event.getStartDate());
//            test.setTime(jExeCtx.getFireTime());
//            schedule.set(Calendar.DATE, -1);
            List<EventDateUser> users = e.getEventDateUserList();
//            if ((schedule.get(Calendar.DAY_OF_YEAR) - test.get(Calendar.DAY_OF_YEAR)) <= 2) {

                for (EventDateUser user : users) {

                    String email = user.getUserId().getEmail();
                    String body = String.format("%s%s%n%s%n%n%s%n%s", "Hi ", user.getUserId().getName() + " ,", "Please remember to attend the coming Alberta Bike Swap event, thank you.", "Regards,", "Laura");
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
