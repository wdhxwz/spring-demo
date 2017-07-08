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

public class SimpleApp {

	public static void main(String[] args) throws SchedulerException {
		new SimpleApp().task();
	}

	/**
	 * 触发器和调度器
	 * 
	 * @throws SchedulerException
	 */
	public void task() throws SchedulerException {
		// 构造一个标准的调度器工厂，并生成调度器
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();

		// 引进作业程序
		JobDataMap jobDataMap = new JobDataMap();
		jobDataMap.put("name", "wangdh" + new Random().nextInt());
		JobDetail jobDetail = JobBuilder.newJob(SimpleQuartzJob.class)
				.setJobData(jobDataMap).build();

		// 构建一个触发器并设置启动时间
//		Trigger simpleTrigger = TriggerBuilder.newTrigger().forJob(jobDetail).startAt(new Date())
//				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).withRepeatCount(5))
//				.build();

		// CronTrigger
		Trigger cronTrigger = TriggerBuilder.newTrigger().forJob(jobDetail).startAt(new Date())
				.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * ? * *")).build();

		// 设置作业和触发器到调度器中并于1秒后触发
		// scheduler.scheduleJob(jobDetail, simpleTrigger);
		scheduler.scheduleJob(jobDetail, cronTrigger);
		scheduler.startDelayed(1);
	}
}