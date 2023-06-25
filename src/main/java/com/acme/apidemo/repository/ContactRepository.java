package com.acme.apidemo.repository;

import java.util.List;

import com.acme.apidemo.entity.Contact;
import com.acme.apidemo.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {

    Contact findByContactId(long id);
    List<Contact> findByCustomerId(long customerId);
}