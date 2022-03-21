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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import models.EventDate;
import org.apache.log4j.BasicConfigurator;
//import org.quartz.CronScheduleBuilder;  
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

public class QuartzScheduler implements ServletContextListener {

    private Scheduler scheduler;
    private Date startTime = new Date();
    private EventDate eventDate;
    private EventDateDB eventDB = EventDateDB.getInstance();

    public QuartzScheduler() {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2099);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DATE, -1);
        this.startTime = cal.getTime();

    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(EventDate eventDate) {
        this.eventDate = eventDate;
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
        StdSchedulerFactory factory=new StdSchedulerFactory();
        try {
            //factory.initialize(ctx.getServletContext().getResourceAsStream("/WEB-INF/quartz.properties"));
            factory.initialize();
            scheduler=factory.getScheduler();
     
        //scheduler.start();
        List<EventDate> events = eventDB.getAllUnheld();
        for(EventDate ev:events){
        System.out.println(ev.getEventDateId()+" "+ev.getAddressId().getCityId().getCityName()+" "+ev.getStartDate() );
        }
        ctx.getServletContext().setAttribute("events", events);
        Calendar cal = Calendar.getInstance();
        if (events != null && events.size() > 0) {
          
                scheduler = ((StdSchedulerFactory) ctx.getServletContext()
                        .getAttribute(
                                QuartzInitializerListener.QUARTZ_FACTORY_KEY))
                        .getScheduler();
                for (EventDate e : events) {
                    JobDetail job = JobBuilder.newJob(CreateQuartzJob.class)
                            .withIdentity("myJob" + e.getEventDateId(), "group1" + e.getEventId()).build();
                    cal = Calendar.getInstance();
                    cal.setTime(e.getStartDate());
                    cal.add(Calendar.DATE, -1);
                    job.getJobDataMap().put("event", e);
                    // Trigger the job to run now, and then every 10 minutes
                    Trigger trigger = TriggerBuilder
                            .newTrigger()
                            .withIdentity("myTrigger" + e.getEventDateId(), "group1").startAt(cal.getTime()).build();// need to figure out how to pass Date variable

                    // Tell quartz to schedule the job using our trigger
                    scheduler.scheduleJob(job, trigger);
                    scheduler.start();
                }
            }
        } catch (SchedulerException ex) {
                ex.printStackTrace();
            }

            try {
                for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals("group1"))) {
                    String jobName = jobKey.getName();
                    String jobGroup = jobKey.getGroup();
                    List<Trigger> triggers = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
                    Date nextFireTime = triggers.get(0).getNextFireTime();
                    System.out.println("[jobNaame]: " + jobName + " jobGroup: " + jobGroup + " - " + nextFireTime);

                };
            } catch (SchedulerException ex) {
                Logger.getLogger(QuartzScheduler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }


