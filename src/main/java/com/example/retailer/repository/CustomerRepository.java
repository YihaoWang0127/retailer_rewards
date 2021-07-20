package com.example.retailer.repository;

import com.example.retailer.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    public Customer findByCustomerId(Long customerId);
}
