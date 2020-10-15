package com.liuzhihang.trace;

import com.liuzhihang.trace.service.ProviderDemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@EnableDubbo(scanBasePackages = "com.liuzhihang")
@SpringBootApplication
public class TraceDemo1Application {

    @DubboReference(url = "dubbo://127.0.0.1:12345")
    private ProviderDemoService providerDemoService;

    public static void main(String[] args) {

        // 注 .close
        SpringApplication.run(TraceDemo1Application.class, args).close();

        log.info("启动 OK");

    }

    @Bean
    public ApplicationRunner runner() {

        log.info("调用 provider ...");

        return args -> providerDemoService.demoTest();
    }

}
