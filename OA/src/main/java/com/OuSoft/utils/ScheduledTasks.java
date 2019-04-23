/*
package com.OuSoft.utils;


import com.OuSoft.system.entity.Plan;
import com.OuSoft.system.entity.Tactivity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
    public class ScheduledTasks implements SchedulingConfigurer {
        private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
        private  static final SimpleDateFormat dataFromat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        @Mapper
        public interface CronMapper{
            @Select("SELECT cron,id FROM tactivity WHERE status!='03'")
            List<Tactivity> getCron();
        }

        @Autowired
        @SuppressWarnings("all")
        CronMapper cronMapper;
        @Override
        public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
            scheduledTaskRegistrar.addTriggerTask(
                    //1.添加任务内容(Runnable)
                    () -> System.out.println("执行定时任务2: " +dataFromat.format(new Date())),
                    //2.设置执行周期(Trigger)
                    triggerContext -> {
                        //2.1 从数据库获取执行周期
                        List<Tactivity> cron = cronMapper.getCron();
                        //2.2 合法性校验.
                        */
/*for(int i=0;i<cron.size();i++){
                            if (StringUtils.isEmpty(cron.get(i).getCron().split(",")[0]) && StringUtils.isEmpty(cron.get(i).getCron().split(",")[1])) {
                                // Omitted Code ..
                                if(cron.get(i).getCron().split(",")[0].equals(dataFromat.format(new Date()))){

                                }
                            }
                        }*//*


                        //2.3 返回执行周期(Date)
                        return new CronTrigger(cron.get(0).getCron()).nextExecutionTime(triggerContext);
                    }
            );
        }
        }

*/
