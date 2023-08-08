package com.szw.missyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.persistence.Entity;

@SpringBootApplication
@EntityScan("com.szw.missyou.model")
public class Missyou2Application {

    public static void main(String[] args) {
        SpringApplication.run(Missyou2Application.class, args);
    }

}
