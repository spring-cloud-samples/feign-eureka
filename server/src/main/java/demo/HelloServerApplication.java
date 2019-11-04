package demo;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Spencer Gibb
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class HelloServerApplication {
	@Autowired
	DiscoveryClient client;

	@RequestMapping("/")
	public String hello() {
		List<ServiceInstance> instances = client.getInstances("HelloServer");
		ServiceInstance selectedInstance = instances
				.get(new Random().nextInt(instances.size()));
		return "Hello World: " + selectedInstance.getServiceId() + ":" + selectedInstance
				.getHost() + ":" + selectedInstance.getPort();
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloServerApplication.class, args);
	}
}
