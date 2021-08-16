package com.hicola.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 *
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/16
 * @
 */
@Component
public class Task {
    private static final Logger logger = LoggerFactory.getLogger(Task.class);


    /***定时任务:
     * 当方法的执行时间超过任务调度频率时，调度器会在下个周期执行，
     * 即：假设work1()方法在第0秒开始执行，方法执行了12秒，那么下一次执行work1()方法的时间是第20秒
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void work1() {
        logger.info("work1 is running");
    }

    /**
     * 固定间隔任务:
     * 下一次的任务执行时间，是从方法最后一次任务执行结束时间开始计算。并以此规则开始周期性的执行任务
     * 即：假设work2()方法在第0秒开始执行，方法执行了12秒，那么下一次执行work2()方法的时间是第22秒
     */
    @Scheduled(fixedDelay = 1000 * 10)
    public void work2() {
        logger.info("work2 is running");
    }

    /**
     * 固定频率任务:
     * 按照指定频率执行任务，并以此规则开始周期性的执行调度,当方法的执行时间超过任务调度频率时，调度器会在当前方法执行完成后立即执行下次任务
     * 即：假设work3()方法在第0秒开始执行，方法执行了12秒，那么下一次执行work3()方法的时间是第12秒
     */
    @Scheduled(fixedRate = 1000 * 10)
    public void work3() {
        logger.info("work3 is running");
    }


}
