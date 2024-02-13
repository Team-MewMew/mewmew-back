package com.mewmew.mewmewback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MewMewBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(MewMewBackApplication.class, args);
    }

}
