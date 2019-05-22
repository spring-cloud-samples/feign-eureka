package org.fegin.demo.client;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

/**
 * @author steel
 * @datetime 2019/4/28 11:46
 */
public class HystrixServletRegistrationBean extends ServletRegistrationBean<HystrixMetricsStreamServlet> {

    public HystrixServletRegistrationBean(HystrixMetricsStreamServlet servlet, String... urlMappings) {
        super(servlet, urlMappings);
    }

}
