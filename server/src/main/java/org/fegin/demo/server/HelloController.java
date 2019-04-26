package org.fegin.demo.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author steel
 * @datetime 2019/4/26 16:13
 */
@RestController
public class HelloController {
    private final DiscoveryClient discoveryClient;

    @Autowired
    public HelloController(DiscoveryClient client) {
        this.discoveryClient = client;
    }

    @RequestMapping("/")
    public String hello() throws JsonProcessingException {
        List<String> localInstance = discoveryClient.getServices();
        return "Hello World: "+ new ObjectMapper().writeValueAsString(localInstance);
    }
}
