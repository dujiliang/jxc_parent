package com.jxc.short_message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.jxc"})
//@ServletComponentScan
public class ShortMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShortMessageApplication.class, args);
    }


}
