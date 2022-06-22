package com.tobias.decalcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class DecalCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(DecalCenterApplication.class, args);
    }

}
