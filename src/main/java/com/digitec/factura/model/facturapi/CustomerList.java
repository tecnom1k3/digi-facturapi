package com.digitec.factura.model.facturapi;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerList {
    private Integer page;
    private Integer total_pages;
    private Integer total_results;
}
