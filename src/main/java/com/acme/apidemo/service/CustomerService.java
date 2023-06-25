package com.acme.apidemo.service;

import com.acme.apidemo.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    // Save operation
    Customer saveCustomer(Customer customer);

    // Read operation
    List<Customer> fetchCustomerList();

    // Update operation
    Customer updateCustomer(Customer Customer, Long CustomerId);

    // Read operation
    Customer getCustomer(long customerId);

    // Update operation
    Customer updateCustomer(Customer customer, long customerId);

    // Delete operation
    void deleteCustomerById(Long CustomerId);
}
