package com.digitec.factura.controller;

import org.springframework.http.ResponseEntity;

public interface RestResourceController {
    ResponseEntity<Object> getAll();
}
