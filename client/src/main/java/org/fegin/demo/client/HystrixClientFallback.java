package org.fegin.demo.client;

import org.springframework.stereotype.Service;

/**
 * @author steel
 * @datetime 2019/4/26 15:55
 */
@Service
public class HystrixClientFallback implements HelloClient {
    @Override
    public String hello() {
        return "fallback";
    }
}
