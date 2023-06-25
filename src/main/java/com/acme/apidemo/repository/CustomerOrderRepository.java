package com.acme.apidemo.repository;

import com.acme.apidemo.entity.CustomerOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerOrderRepository extends CrudRepository<CustomerOrder, Long> {
    CustomerOrder findByOrderId(long orderId);
    List<CustomerOrder> findByCustomerId(long customerId);
}
