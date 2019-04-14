package com.digitec.factura.controller;

import com.digitec.factura.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@AllArgsConstructor
public class CustomerController implements RestResourceController {

    @Resource
    private ClientService clientService;

    @Override
    @RequestMapping(value = "/cliente")
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(clientService.getClients(), HttpStatus.OK);
    }
}
