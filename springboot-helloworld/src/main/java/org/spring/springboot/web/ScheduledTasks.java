package org.spring.springboot.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * 
 * @author lichaoi*@date 2018 年05月23日 20:50<br/>
 *         *说明：定时任务
 */
@Component
public class ScheduledTasks {

	private Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

	private int fixedDelayCount = 1;
	private int fixedRateCount = 1;
	private int initialDelayCount = 1;
	private int cronCount = 1;

	// fixedDelay = 5000表示当前方法执行完毕5000ms后，Spring scheduling会再次调用该方法
	@Scheduled(fixedDelay = 5000)
	public void testFixDelay() {
		logger.info("===fixedDelay: 第{}次执行方法", fixedDelayCount++);
	}

	// fixedRate = 5000表示当前方法开始执行5000ms后，Spring scheduling会再次调用该方法
	@Scheduled(fixedRate = 5000)
	public void testFixedRate() {
		logger.info("===fixedRate: 第{}次执行方法", fixedRateCount++);
	}

	// initialDelay = 1000表示延迟1000ms执行第一次任务
	@Scheduled(initialDelay = 1000, fixedRate = 5000)
	public void testInitialDelay() {
		logger.info("===initialDelay: 第{}次执行方法", initialDelayCount++);
	}

	// cron接受cron表达式，根据cron表达式确定定时规则
	@Scheduled(cron = "*/10 * * * * *")
	public void testCron() {
		logger.info("===initialDelay: 第{}次执行方法", cronCount++);
	}

	// 每分钟启动
	@Scheduled(cron = "0 0/1 * * * ?")
	public void timerToNow() {
		System.out.println("now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}
}
