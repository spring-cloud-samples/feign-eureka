package org.fegin.demo.client;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author steel
 * @datetime 2019/4/26 17:39
 */
@Service
public class HelloClientFallbackFactory implements FallbackFactory<HelloClient> {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloClientFallbackFactory.class);
    private HelloClient helloClient;

    public HelloClientFallbackFactory(@Qualifier("helloClientFallback") HelloClient helloClient) {
        this.helloClient = helloClient;
    }

    @Override
    public HelloClient create(Throwable throwable) {
        LOGGER.error("fallback error ", throwable);
        return helloClient;
    }
}
