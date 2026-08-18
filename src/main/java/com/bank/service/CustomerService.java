package com.bank.service;

import java.util.List;

import com.bank.entity.Customer;

public interface CustomerService {

	Customer createCustomer(Customer customer);

    Customer updateCustomer(Long id,Customer customer);

    void deleteCustomer(Long id);

    Customer getCustomerById(Long id);

    List<Customer> getAllCustomers();

}
