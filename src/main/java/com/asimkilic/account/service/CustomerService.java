package com.asimkilic.account.service;

import com.asimkilic.account.exception.CustomerNotFoundException;
import com.asimkilic.account.model.Customer;
import com.asimkilic.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    protected Customer findCustomerById(String id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer could not find by id : " + id));
    }
}
