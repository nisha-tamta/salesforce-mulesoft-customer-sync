package com.nisha.mockerp.controller;

import com.nisha.mockerp.model.CustomerRequest;
import com.nisha.mockerp.model.CustomerResponse;
import com.nisha.mockerp.service.CustomerService;
import jakarta.validation.Valid;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/erp/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse upsert(@Valid @RequestBody CustomerRequest request) {
        return customerService.upsert(request);
    }

    @GetMapping("/{externalId}")
    public CustomerResponse getByExternalId(@PathVariable String externalId) {
        return customerService.findByExternalId(externalId);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> notFound(IllegalArgumentException ex) {
        return Map.of("status", "FAILED", "message", ex.getMessage());
    }
}
