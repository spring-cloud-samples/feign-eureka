package org.fegin.demo.client;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author steel
 * @datetime 2019/4/26 16:33
 */
public class CommonMainTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonMainTests.class);
    private static HttpClient httpClient = HttpClientBuilder.create().build();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(() -> {
                try {
                    countDownLatch.await();
                    HttpResponse httpResponse = httpClient.execute(new HttpGet("http://192.168.115.1:7211/"));
                    LOGGER.info(IOUtils.toString(httpResponse.getEntity().getContent(), "UTF-8"));
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }
        countDownLatch.countDown();

    }
}
