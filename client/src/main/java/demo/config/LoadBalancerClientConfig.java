package demo.config;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Olga Maciaszek-Sharma
 */
public class LoadBalancerClientConfig {

	@Bean
	public ServiceInstanceListSupplier instanceSupplier(ConfigurableApplicationContext context) {
		return ServiceInstanceListSupplier.builder()
				.withBlockingDiscoveryClient()
				.withHints()
				.withBlockingHealthChecks(new RestTemplate())
				.build(context);
	}
}
