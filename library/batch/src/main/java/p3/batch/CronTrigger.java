package p3.batch;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class CronTrigger {
    public static void main(String[] args) throws Exception {

        JobDetail job = JobBuilder.newJob(BatchJob.class)
                .withIdentity("batchSenderEmail", "group1").build();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("batchSenderEmailTrigger", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 * * * * ?"))
                .build();

        //schedule it
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);

    }
}
