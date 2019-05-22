package org.fegin.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author steel
 * @datetime 2019/4/26 15:56
 */
@RestController
public class HelloController {
    private final HelloClient helloClient;

    @Autowired
    public HelloController(HelloClient helloClient) {
        this.helloClient = helloClient;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String hello() {
        return helloClient.hello();
    }
}
