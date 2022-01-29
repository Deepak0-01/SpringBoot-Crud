package com.example.springbootemployeecrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootEmployeeCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEmployeeCrudApplication.class, args);
    }

}
