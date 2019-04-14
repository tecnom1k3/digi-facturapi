package com.digitec.factura.service;

import com.digitec.factura.model.CustomerListResponse;
import com.digitec.factura.model.facturapi.CustomerList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@AllArgsConstructor
public class ClientService {

    @Resource
    private FacturapiService facturapiService;

    public CustomerListResponse getClients() {

        CustomerList response = facturapiService.getClientList();

        return CustomerListResponse.builder()
                .var(response.toString())
                .build();
    }
}
