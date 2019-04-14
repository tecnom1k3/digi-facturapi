package com.digitec.factura.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FacturapiService {

    @Value("${facturapi.apiKey}")
    private String username;

    String send(String url, HttpMethod httpMethod) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBasicAuth(username, "");

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        return restTemplate.exchange(
                url,
                httpMethod,
                entity,
                String.class
        ).getBody();
    }
}
