package com.digitec.factura.service;

import com.digitec.factura.model.CustomerListResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@AllArgsConstructor
public class ClientService {

    @Resource
    private FacturapiService facturapiService;


    public CustomerListResponse getClients() {

        String response = facturapiService.send("https://www.facturapi.io/v1/customers", HttpMethod.GET);

        return CustomerListResponse.builder()
                .var(response)
                .build();
    }
}
