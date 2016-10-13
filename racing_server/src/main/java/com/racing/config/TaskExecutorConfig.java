package com.racing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class TaskExecutorConfig {

   @Bean
   public TaskExecutor crateTaskExecutor() {
   ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
   taskExecutor.setCorePoolSize(5);
   taskExecutor.setMaxPoolSize(10);
   taskExecutor.setQueueCapacity(15);
   taskExecutor.setKeepAliveSeconds(10 * 60);
   return taskExecutor;
   }

}
