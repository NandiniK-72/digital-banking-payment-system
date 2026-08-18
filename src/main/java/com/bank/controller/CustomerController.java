package com.bank.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.Customer;
import com.bank.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {

        this.service = service;
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
         return service.createCustomer(customer);
    }
    
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {

        return service.getCustomerById(id);
    }
    
    @GetMapping
    public List<Customer> getAllCustomers() {

        return service.getAllCustomers();
    } 
    
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id,@RequestBody Customer customer) {
        return service.updateCustomer(id,customer);
    }
    
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {

        service.deleteCustomer(id);
    }
    
    
    
}

