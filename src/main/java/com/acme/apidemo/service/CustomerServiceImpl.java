package com.acme.apidemo.service;

import com.acme.apidemo.entity.Customer;
import com.acme.apidemo.repository.CustomerRepository;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class CustomerServiceImpl implements CustomerService {

        @Autowired
        private CustomerRepository CustomerRepository;

        // Save operation
        @Override
        public Customer saveCustomer(Customer customer) { return CustomerRepository.save(customer);  }

        // Read operation
        @Override public List<Customer> fetchCustomerList(){ return (List<Customer>)CustomerRepository.findAll();
        }

       // Read operation
        @Override
        public Customer getCustomer(long customerId){
            return (Customer)CustomerRepository.findById(customerId);
        }


        // Update operation
        @Override
        public Customer updateCustomer(Customer customer, long customerId)
        {
            Customer custDB = CustomerRepository.findById(customerId);

            if (Objects.nonNull(customer.getFirstName())  && !"".equalsIgnoreCase( customer.getFirstName())) {
                custDB.setFirstName(customer.getFirstName());
            }

            if (Objects.nonNull(customer.getContact())  && customer.getContact()!=null) {
                custDB.setContact(customer.getContact());
            }

            if (Objects.nonNull(customer.getCustomerOrders())  && !customer.getCustomerOrders().isEmpty()) {
                custDB.setCustomerOrders(customer.getCustomerOrders());
            }

            return CustomerRepository.save(custDB);
        }

        // Delete operation
        @Override
        public void deleteCustomerById(Long CustomerId)
        {
            CustomerRepository.deleteById(CustomerId);
        }

        @Override
        public Customer updateCustomer(Customer Customer, Long CustomerId) {
            return null;
        }
}
