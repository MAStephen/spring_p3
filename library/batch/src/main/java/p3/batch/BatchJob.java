package p3.batch;

import client.BatchWeb;
import client.BatchWs;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Hello world!
 *
 */
public class BatchJob implements Job
{
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Test de quartz");

        BatchWeb batchWeb = new BatchWeb();
        BatchWs batchWs = batchWeb.getBatchWsPort();

        batchWs.sendMailBorrowingExceeded();
    }

}
