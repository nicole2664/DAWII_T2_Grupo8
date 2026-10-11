package com.pagoya.ms_reclamos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsReclamosApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsReclamosApplication.class, args);
    }

}