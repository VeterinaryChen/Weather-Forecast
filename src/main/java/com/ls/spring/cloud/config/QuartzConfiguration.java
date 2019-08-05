package com.ls.spring.cloud.config;

import com.ls.spring.cloud.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: jeffchen
 * 定时器配置
 */
@Configuration
public class QuartzConfiguration {

    private static final int TIME = 1800;  // 服务更新频率，每隔半小时

    // JobDetail 定义一个特定的Job
    @Bean
    public JobDetail weatherSyncJobDetail(){
        return JobBuilder.newJob(WeatherDataSyncJob.class)
                .withIdentity("weatherSyncJob")
                .storeDurably()
                .build();
    }
    // Trigger
    @Bean
    public Trigger weatherDataSyncTrigger(){

        SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule()
        .withIntervalInSeconds(TIME).repeatForever();

        return TriggerBuilder.newTrigger().forJob(weatherSyncJobDetail())
                .withIdentity("weatherDataSyncTrigger").withSchedule(schedBuilder).build();
    }


}
