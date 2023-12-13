package com.example.democinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class DemoCinemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCinemaApplication.class, args);
    }

}
