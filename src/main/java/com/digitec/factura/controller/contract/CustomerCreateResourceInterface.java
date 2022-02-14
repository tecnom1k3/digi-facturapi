package com.digitec.factura.controller.contract;

import org.springframework.http.ResponseEntity;

import javax.validation.constraints.Email;

public interface CustomerCreateResourceInterface extends RestResourceInterface {
    ResponseEntity<Object> create(String rfc, @Email String email, String legalName);
}
