package com.adyan.payment.payment.gateway.configaration.config;

// Import the required classes.


import com.adyen.Client;
import com.adyen.service.checkout.PaymentsApi;
import com.adyen.model.checkout.Amount;
import com.adyen.enums.Environment;
import com.adyen.service.exception.ApiException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class Snippet {

    @Value("${adyen.merchant.account}")
    private String merchantAccount;

    @Value("${adyen.api.key}")
    private String apiKey;

    @Bean
    public Client createClient() throws IOException, ApiException {
        // Set up the client and service.
        Client client = new Client("AQEvhmfxJovGYxFBw0m/n3Q5qf3VfKh+LJBJV3BY0iHzyogljgxivZFfT6rwyqA7cHkQwV1bDb7kfNy1WIxIIkxgBw==-Lwh2NkIzdwv9EOpWYB+iuOD4ZprZ9nEOXz+r4j/n8+s=-i1i=Wn})=7hDk<[S@7p", Environment.TEST);
        return client;
    }
}
