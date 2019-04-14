package com.digitec.factura.enumeration;

import lombok.Getter;

@Getter
public enum FacturapiResource {
    CUSTOMERS("customers");

    private String resource;

    FacturapiResource(String resource) {
        this.resource = resource;
    }
}
