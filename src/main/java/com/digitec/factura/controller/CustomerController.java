package com.digitec.factura.controller;

import com.digitec.factura.controller.contract.CustomerCreateResourceInterface;
import com.digitec.factura.controller.contract.GetAllResourceInterface;
import com.digitec.factura.model.CustomerCreateRequest;
import com.digitec.factura.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Email;

@RestController
@AllArgsConstructor
@Validated
public class CustomerController implements GetAllResourceInterface,
        CustomerCreateResourceInterface {

    @Resource
    private ClientService clientService;

    @Override
    @RequestMapping(value = "/cliente", method = RequestMethod.GET)
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(clientService.getClients(), HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/cliente/{rfc}", method = RequestMethod.PUT)
    public ResponseEntity<Object> create(
            @PathVariable("rfc") String rfc,
            @RequestParam("email") @Email String email,
            @RequestParam("legalName") String legalName
    ) {
        CustomerCreateRequest createRequest = CustomerCreateRequest.builder()
                .tax_id(rfc)
                .email(email)
                .legal_name(legalName)
                .build();

        return new ResponseEntity<>(createRequest, HttpStatus.ACCEPTED);
    }
}
