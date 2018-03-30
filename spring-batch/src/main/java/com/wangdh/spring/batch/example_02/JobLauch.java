package com.wangdh.spring.batch.example_02;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018/3/30.
 */
public class JobLauch {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("example_02/job.xml");
        JobLauncher launcher = context.getBean(JobLauncher.class);

        Job job = (Job)context.getBean("billJob");
        try{
            JobExecution result = launcher.run(job,new JobParameters());
            System.out.println(result.toString());
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
