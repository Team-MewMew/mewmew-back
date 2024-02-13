package com.mewmew.mewmewback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@EnableJpaAuditing // JPA Auditing 활성화, 시간 자동 변경 기능 활성화 시킴.
public class MewMewBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(MewMewBackApplication.class, args);
    }

}
