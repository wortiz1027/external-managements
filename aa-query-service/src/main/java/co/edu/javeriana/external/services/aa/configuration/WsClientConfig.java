package co.edu.javeriana.external.services.aa.configuration;

import co.edu.javeriana.external.services.aa.infraestructure.client.AmericanAirlineWsClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WsClientConfig {

    @Value("${soap.service.aa.url}")
    private String endpoint;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("co.edu.javeriana.external.services.aa.infraestructure.wsdl.model");
        return marshaller;
    }

    @Bean
    public AmericanAirlineWsClient countryClient(Jaxb2Marshaller marshaller) {
        AmericanAirlineWsClient client = new AmericanAirlineWsClient();
        client.setDefaultUri(endpoint);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
