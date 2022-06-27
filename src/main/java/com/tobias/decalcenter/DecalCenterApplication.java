package com.tobias.decalcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DecalCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(DecalCenterApplication.class, args);
    }
}
