package com.wangdh.quartz;

import java.util.Date;
import java.util.Random;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class SimpleApp2 {

	public static void main(String[] args) {
		try {
			// 构造一个标准的调度器工厂，并生成调度器
			SchedulerFactory schedulerFactory = new StdSchedulerFactory();
			Scheduler scheduler = schedulerFactory.getScheduler();

			// 引进作业程序
			JobDataMap jobDataMap = new JobDataMap();
			jobDataMap.put("name", "wangdh" + new Random().nextInt());
			JobDetail jobDetail = JobBuilder.newJob(SimpleQuartzJob2.class)
					.setJobData(jobDataMap).build();

			// CronTrigger
			Trigger cronTrigger = TriggerBuilder.newTrigger().forJob(jobDetail).startAt(new Date())
					.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * ? * *")).build();

			// 设置作业和触发器到调度器中并于1秒后触发
			scheduler.scheduleJob(jobDetail, cronTrigger);
			scheduler.startDelayed(1);

        } catch (SchedulerException se) {
            se.printStackTrace();
        }
	}
}
