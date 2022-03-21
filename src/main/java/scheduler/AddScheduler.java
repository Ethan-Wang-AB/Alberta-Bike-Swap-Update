/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduler;

import java.util.Calendar;
import javax.servlet.ServletContextEvent;
import models.EventDate;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author 845593
 */
public class AddScheduler {
    
    public void addScheduler(EventDate e){
    Calendar cal;
    JobDetail job = JobBuilder.newJob(CreateQuartzJob.class)
                    .withIdentity("myJob"+e.getEventDateId(), "group1"+e.getEventId()).build();
            cal=Calendar.getInstance();
            cal.setTime(e.getStartDate());
            cal.add(Calendar.DATE, -1);
            job.getJobDataMap().put("event", e);
            // Trigger the job to run now, and then every 10 minutes
            Trigger trigger = TriggerBuilder
                    .newTrigger()
                    .withIdentity("myTrigger"+e.getEventDateId(), "group1"+e.getEventId()).startAt(cal.getTime()).build();// need to figure out how to pass Date variable
            Scheduler scheduler;
            SchedulerFactory stdSchedulerFactory=new StdSchedulerFactory();
            // Tell quartz to schedule the job using our trigger
            try {
                            scheduler=stdSchedulerFactory.getScheduler();

//                scheduler = ((StdSchedulerFactory) ctx.getServletContext()
//                        .getAttribute(
//                                QuartzInitializerListener.QUARTZ_FACTORY_KEY))
//                        .getScheduler();
                scheduler.scheduleJob(job, trigger);
            } catch (SchedulerException ex) {
                ex.printStackTrace();
            }
            }
        }


