package com.progile.Scheduler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.util.Date;
import java.util.Set;

@EnableScheduling
@Slf4j
@Configuration
public class Scheduler {
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
