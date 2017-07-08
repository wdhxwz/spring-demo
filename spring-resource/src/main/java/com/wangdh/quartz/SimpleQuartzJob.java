package com.wangdh.quartz;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;

/**
 * 简单的调度作业 <br/>
 * 必须有一个无参的构造器 <br/>
 * 在Job类中定义数据属性是没有意义的，因为这些属性值并不会在执行期间保存
 * 
 * @author wdhcxx
 */
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class SimpleQuartzJob implements Job {
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		String name = jobDataMap.getString("name");
		System.out.println("简单的调度作业,name:" + name + "," + System.currentTimeMillis());
	}
}