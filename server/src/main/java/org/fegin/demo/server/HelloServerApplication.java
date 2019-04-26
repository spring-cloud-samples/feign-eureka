package org.fegin.demo.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Spencer Gibb
 */
@SpringBootApplication
@EnableDiscoveryClient
public class HelloServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(HelloServerApplication.class, args);
	}
}
