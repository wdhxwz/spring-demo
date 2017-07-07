package com.wangdh.spring.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * spring 定時任务
 * 
 * @author wangdh 2017年7月7日上午10:48:14
 */
public class SpringQtz extends QuartzJobBean {
	private static int counter = 0;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		System.out.println("开始执行任务...");
		long ms = System.currentTimeMillis();
		System.out.println(ms);
		System.out.println("(" + counter++ + ")");
		String s = (String) context.getMergedJobDataMap().get("service");
		System.out.println(s);
	}
}