package com.customerservice.customerservice.service;

import com.customerservice.customerservice.dto.response.OpenStreetMapResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class GeolocationService {

    private final RestTemplate restTemplate;

    @Value("${api.openstreetmap-search.url}")
    private String apiUrl;

    public OpenStreetMapResponse getCoordinatesFromQuery(String street, String city, String state, String country, String postalcode) {

        String url = apiUrl
                .replace("{street}", street)
                .replace("{city}", city)
                .replace("{state}", state)
                .replace("{country}", country)
                .replace("{postalcode}", postalcode);


        ResponseEntity<OpenStreetMapResponse[]> responseEntity = restTemplate.getForEntity(url, OpenStreetMapResponse[].class);

        try {
            OpenStreetMapResponse[] responses = responseEntity.getBody();

            if (responses == null || responses.length == 0) {
                throw new RuntimeException("Resposta vazia da API OpenStreetMap");
            }

            return responses[0];
        } catch (Exception e) {
            throw new RuntimeException("Erro ao processar a resposta da API OpenStreetMap", e);
        }
    }
}
