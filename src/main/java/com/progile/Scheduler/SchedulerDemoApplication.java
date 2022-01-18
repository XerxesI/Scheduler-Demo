package com.progile.Scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EnableScheduling
@Slf4j
@SpringBootApplication
public class SchedulerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulerDemoApplication.class, args);
	}

	public static final int DEPTH = 1;

	@Scheduled(cron="*/3 * * * * *")
	public void TestDirectoryList() {
//            System.out.println(PropertiesCache.getInstance().getProperty("filepath"));
		log.info("Job start time "+new Date());

		try {
			String filePath = PropertiesCache.getInstance().getProperty("filepath");
			Set<String> results = ListFiles.listFilesUsingFileWalk(filePath, 1);
			results.stream().forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Something went wrong.");
		}
	}



}
