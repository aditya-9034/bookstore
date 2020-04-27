package aditya.netent.assignment.bookstore.configurations;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JestClientConfig {

    @Value("${es.host}")
    private String esHost;

    @Bean
    public JestClient jestClient(){
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(
            new HttpClientConfig.Builder(esHost)
                                .multiThreaded(true)
                                .defaultMaxTotalConnectionPerRoute(2)
                                .maxTotalConnection(10)
                                .build()
        );

        return factory.getObject();
    }
}
