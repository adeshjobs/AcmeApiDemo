package com.acme.apidemo.controller;

import com.acme.apidemo.entity.Customer;
import com.acme.apidemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Save operation
    @PostMapping("/customers")
    public Customer saveCustomer( @RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    // Read operation
    @GetMapping("/customers")
    public List<Customer> fetchCustomerList(){
        return customerService.fetchCustomerList();
    }

    // Update operation
    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("id") Long customerId){
        return customerService.updateCustomer(customer, customerId);
    }

    // Update operation
    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable("id") Long customerId){
        return customerService.getCustomer(customerId);
    }

    // Delete operation
    @DeleteMapping("/customers/{id}")
    public String deleteCustomerById(@PathVariable("id") Long customerId)
    {
        customerService.deleteCustomerById(customerId);
        return "Deleted Successfully";
    }
}
