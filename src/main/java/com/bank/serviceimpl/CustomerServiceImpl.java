package com.bank.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.entity.Customer;
import com.bank.repository.CustomerRepository;
import com.bank.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService{

	private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
      }
    
	@Override
	public Customer createCustomer(Customer customer) {
		return repository.save(customer);
	}

	@Override
	public Customer updateCustomer(Long id, Customer customer) {
		Customer existing =
                repository.findById(id)
                .orElseThrow(() ->
                new RuntimeException(
                "Customer Not Found"));

        existing.setFirstName(
                customer.getFirstName());

        existing.setLastName(
                customer.getLastName());

        existing.setEmail(
                customer.getEmail());

        existing.setPhone(
                customer.getPhone());

        existing.setAddress(
                customer.getAddress());

        return repository.save(existing);
	}

	@Override
	public void deleteCustomer(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public Customer getCustomerById(Long id) {
		return repository.findById(id)
                .orElseThrow(() ->
                new RuntimeException(
                "Customer Not Found"));
	}

	@Override
	public List<Customer> getAllCustomers() {
		return repository.findAll();
	}

}
