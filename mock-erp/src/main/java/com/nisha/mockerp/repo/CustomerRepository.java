package com.nisha.mockerp.repo;

import com.nisha.mockerp.model.CustomerEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    Optional<CustomerEntity> findByExternalId(String externalId);
}
