package com.liuzhihang.trace;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo(scanBasePackages = "com.liuzhihang")
@SpringBootApplication
public class TraceDemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(TraceDemo2Application.class, args);
    }

}
