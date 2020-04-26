package aditya.netent.assignment.bookstore.configurations;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JestClientConfig {

    @Bean
    public JestClient jestClient(){
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(
            new HttpClientConfig.Builder("https://pmiqtborz:r8xxa4glyn@bookstore-7320592115.ap-southeast-2.bonsaisearch.net:443")
                                .multiThreaded(true)
                                .defaultMaxTotalConnectionPerRoute(2)
                                .maxTotalConnection(10)
                                .build()
        );

        return factory.getObject();
    }
}
