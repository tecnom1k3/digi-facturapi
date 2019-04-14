package com.digitec.factura.service;

import com.digitec.factura.model.PingResponse;
import org.springframework.stereotype.Service;

@Service
public class PingService {
    public PingResponse getPing() {
        return PingResponse.builder()
                .ping("pong")
                .build();
    }
}
