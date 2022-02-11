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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import models.EventDate;
import org.apache.log4j.BasicConfigurator;
//import org.quartz.CronScheduleBuilder;  
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzScheduler implements ServletContextListener {

    private Scheduler scheduler;
    private Date startTime=new Date();
    private EventDate eventDate;

    public QuartzScheduler() {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2099);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DATE,-1);
        this.startTime = cal.getTime();

    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(EventDate eventDate) {
        this.eventDate=eventDate;
       Calendar cal = Calendar.getInstance();
        cal.setTime(eventDate.getStartDate());
       
        this.startTime = eventDate.getStartDate();
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

    }

    @Override
    public void contextInitialized(ServletContextEvent ctx) {
        // define the job and tie it to our CreateQuartzJob class
        ctx.getServletContext().setAttribute("events", new ArrayList<EventDate>().add(eventDate));
        JobDetail job = JobBuilder.newJob(CreateQuartzJob.class)
                .withIdentity("myJob", "group1").build();

        // Trigger the job to run now, and then every 10 minutes
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("myTrigger", "group1").startAt(startTime).build();// need to figure out how to pass Date variable

        // Tell quartz to schedule the job using our trigger
        try {
            scheduler = ((StdSchedulerFactory) ctx.getServletContext()
                    .getAttribute(
                            QuartzInitializerListener.QUARTZ_FACTORY_KEY))
                    .getScheduler();
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
e.printStackTrace();
        }
    }

}
