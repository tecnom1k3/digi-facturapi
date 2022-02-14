package com.digitec.factura.model.facturapi;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerList {
    private Integer page;
    private Integer total_pages;
    private Integer total_results;
    private List<Object> data;
}
