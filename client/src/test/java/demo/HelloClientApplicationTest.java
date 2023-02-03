package demo;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@Import(HelloClientApplicationTest.WireMockConfig.class)
class HelloClientApplicationTest {

    @Autowired
    private WireMockServer helloServer;
    @Autowired
    private HelloClientApplication.HelloClient helloClient;
    @MockBean
    private DiscoveryClient discoveryClient;

    @Test
    void testHelloServer() {
        // given
        helloServer.stubFor(WireMock.get("/")
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withBody("Hello Server Response")));

        // when
        String feignClientResponse = helloClient.hello();

        // then
        assertThat(feignClientResponse, is("Hello Server Response"));

    }

    static class WireMockConfig {
        @Bean(initMethod = "start", destroyMethod = "stop")
        public WireMockServer mockService() {
            return new WireMockServer(7333);
        }
    }
}