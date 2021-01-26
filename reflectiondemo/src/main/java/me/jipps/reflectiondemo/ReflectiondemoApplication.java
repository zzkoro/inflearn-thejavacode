package me.jipps.reflectiondemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ReflectiondemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReflectiondemoApplication.class, args);
    }

}
