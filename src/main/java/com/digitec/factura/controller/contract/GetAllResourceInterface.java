package com.digitec.factura.controller.contract;

import org.springframework.http.ResponseEntity;

public interface GetAllResourceInterface extends RestResourceInterface {
    ResponseEntity<Object> getAll();
}
