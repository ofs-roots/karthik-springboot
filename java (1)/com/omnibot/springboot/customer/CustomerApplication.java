package com.omnibot.springboot.customer;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CustomerApplication {

    static Logger log = Logger.getLogger("CustomerApplication");

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
        log.warn("Warning : Customer application checking warn");
        log.debug("Debug : Customer application checking debug");
        log.error("Error : Customer application checking error");
        log.fatal("Fatal : Customer application checking fatal");
        log.info("Info : Customer application started");
    }

//    @Configuration
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/customer").allowedOrigins("http://localhost:8080");
//            }
//        };
//    }
}
