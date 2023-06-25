package com.acme.apidemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {


  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long customerId;
  private String firstName;
  private String lastName;
  private String email;

  @OneToOne
  private Contact contact;

  @OneToMany(mappedBy = "customerId", fetch = FetchType.EAGER)
  private List<CustomerOrder> customerOrders;



  public Customer(String firstName, String lastName, String email){
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

}