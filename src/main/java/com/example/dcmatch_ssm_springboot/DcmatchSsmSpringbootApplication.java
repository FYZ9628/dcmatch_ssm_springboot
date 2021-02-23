package com.example.dcmatch_ssm_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DcmatchSsmSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DcmatchSsmSpringbootApplication.class, args);
    }

}
