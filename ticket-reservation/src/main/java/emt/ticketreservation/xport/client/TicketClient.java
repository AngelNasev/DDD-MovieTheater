package emt.ticketreservation.xport.client;

import emt.ticketreservation.domain.valueobjects.TicketValueObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
public class TicketClient {
    private final RestTemplate restTemplate;
    private final String serverUrl;

    public TicketClient(@Value("${app.movie-projection.url}") String serverUrl) {
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }

    public List<TicketValueObject> findAll() {
        try {
            return restTemplate.exchange(uri().path("/api/tickets").build().toUri(), HttpMethod.GET,null, new ParameterizedTypeReference<List<TicketValueObject>>() {
            }).getBody();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
