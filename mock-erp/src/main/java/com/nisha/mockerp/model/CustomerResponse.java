package com.nisha.mockerp.model;

import java.time.OffsetDateTime;

public record CustomerResponse(
        String externalId,
        String customerName,
        String billingCity,
        String billingCountry,
        String salesforceId,
        String status,
        OffsetDateTime lastUpdated
) {}
