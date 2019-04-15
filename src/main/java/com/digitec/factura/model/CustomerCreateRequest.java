package com.digitec.factura.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCreateRequest {
    private String legal_name;
    private String email;
    private String tax_id;
}
