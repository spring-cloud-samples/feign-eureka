package demo;

import java.util.List;

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
	    StringBuilder result = new StringBuilder("Hello World: ");
	    List<String> services = client.getServices();
	    for(String serviceId: services) {
	        List<ServiceInstance> localInstances = client.getInstances(serviceId);
	        for(ServiceInstance instance: localInstances) {
	            result.append(instance.getServiceId()+":"+instance.getHost()+":"+instance.getPort());
	        }
	    }
		return result.toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloServerApplication.class, args);
	}
}
