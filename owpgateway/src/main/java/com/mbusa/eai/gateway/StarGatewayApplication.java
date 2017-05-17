package com.mbusa.eai.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Controller;


@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableHystrix
public class StarGatewayApplication {

	public static void main(String[] args) {
		// System.setProperty("spring.config.name", "registration-server");
		SpringApplication.run(StarGatewayApplication.class, args);
		System.out.println("OWP-SCSP ZUUL gateway established::");

	}

}
