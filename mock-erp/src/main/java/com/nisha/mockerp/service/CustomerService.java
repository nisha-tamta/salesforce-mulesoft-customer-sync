package com.nisha.mockerp.service;

import com.nisha.mockerp.model.CustomerEntity;
import com.nisha.mockerp.model.CustomerRequest;
import com.nisha.mockerp.model.CustomerResponse;
import com.nisha.mockerp.repo.CustomerRepository;
import java.time.OffsetDateTime;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerResponse upsert(CustomerRequest request) {
        CustomerEntity entity = customerRepository.findByExternalId(request.getExternalId())
                .orElseGet(CustomerEntity::new);

        entity.setExternalId(request.getExternalId());
        entity.setCustomerName(request.getCustomerName());
        entity.setBillingCity(request.getBillingCity());
        entity.setBillingCountry(request.getBillingCountry());
        entity.setSalesforceId(request.getSalesforceId());
        entity.setStatus(request.getStatus() == null || request.getStatus().isBlank() ? "ACTIVE" : request.getStatus());
        entity.setLastUpdated(OffsetDateTime.now());

        CustomerEntity saved = customerRepository.save(entity);
        return toResponse(saved);
    }

    public CustomerResponse findByExternalId(String externalId) {
        CustomerEntity entity = customerRepository.findByExternalId(externalId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found for externalId=" + externalId));
        return toResponse(entity);
    }

    private CustomerResponse toResponse(CustomerEntity entity) {
        return new CustomerResponse(
                entity.getExternalId(),
                entity.getCustomerName(),
                entity.getBillingCity(),
                entity.getBillingCountry(),
                entity.getSalesforceId(),
                entity.getStatus(),
                entity.getLastUpdated()
        );
    }
}
