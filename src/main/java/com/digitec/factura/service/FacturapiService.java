package com.digitec.factura.service;

import com.digitec.factura.enumeration.FacturapiResource;
import com.digitec.factura.model.facturapi.CustomerList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Service
public class FacturapiService {

    @Value("${facturapi.apiKey}")
    private String username;

    @Value("${facturapi.url}")
    private String facturapiUrl;

    private RestTemplate restTemplate;

    private HttpHeaders httpHeaders;

    @PostConstruct
    private void createRestTemplate() {
        restTemplate = new RestTemplate();
        httpHeaders = new HttpHeaders();
        httpHeaders.setBasicAuth(username, "");
    }

    CustomerList getClientList() {
        HttpEntity<CustomerList> entity = new HttpEntity<>(httpHeaders);

        return restTemplate.exchange(
                facturapiUrl + FacturapiResource.CUSTOMERS.getResource(),
                HttpMethod.GET,
                entity,
                CustomerList.class
        ).getBody();
    }
}
