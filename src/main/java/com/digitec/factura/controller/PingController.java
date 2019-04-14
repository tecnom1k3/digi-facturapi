package com.digitec.factura.controller;

import com.digitec.factura.service.PingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@AllArgsConstructor
public class PingController implements RestResourceController {

    @Resource
    PingService pingService;

    @Override
    @RequestMapping(value = "/ping")
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(pingService.getPing(), HttpStatus.OK);
    }
}
