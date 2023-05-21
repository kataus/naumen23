package ru.itvitality.meetup.naumen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class DataServiceAsyncRunner {
    public static void main( String[] args ) {
        SpringApplication.run( DataServiceAsyncRunner.class, args );
    }
}
