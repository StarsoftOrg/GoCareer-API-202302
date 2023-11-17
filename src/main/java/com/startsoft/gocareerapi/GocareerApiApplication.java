package com.startsoft.gocareerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GocareerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GocareerApiApplication.class, args);
    }

}
