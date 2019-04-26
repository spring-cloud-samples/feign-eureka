package org.fegin.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author steel
 * @datetime 2019/4/26 15:55
 */
@FeignClient(name = "HelloServer", fallback = HystrixClientFallback.class)
public interface HelloClient {
    @RequestMapping(value = "/", method = GET)
    String hello();
}
