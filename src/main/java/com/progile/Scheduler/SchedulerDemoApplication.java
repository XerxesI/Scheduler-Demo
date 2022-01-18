package com.progile.Scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@Slf4j
@SpringBootApplication
@EnableScheduling
public class SchedulerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulerDemoApplication.class, args);
	}

	@Scheduled(cron="*/2 * * * * *")
	public void job() throws InterruptedException {
		log.info("Job current time"+ new Date());
		Thread.sleep(1000L);

	}

	@Scheduled(cron="*/2 * * * * *")
	public void job2() throws InterruptedException {
		log.info("Job2 current time"+ new Date());
		Thread.sleep(1000L);

	}

}
